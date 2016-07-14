package com.whoami.daoDo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.jclouds.blobstore.domain.PageSet;
import org.jclouds.io.Payloads;
import org.jclouds.openstack.swift.SwiftKeystoneClient;
import org.jclouds.openstack.swift.domain.MutableObjectInfoWithMetadata;
import org.jclouds.openstack.swift.domain.ObjectInfo;
import org.jclouds.openstack.swift.domain.SwiftObject;

import com.whoami.dao.ObjectDao;
import com.whoami.sessionHelper.ClientConnection;
import com.whomai.po.ObjectPo;

public class ObjectDaoDo implements ObjectDao{

	public List<ObjectPo> getAllObject(String username, String pass, String container) {
		List<ObjectPo> list = new ArrayList<ObjectPo>();
		SimpleDateFormat time=new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
		SwiftKeystoneClient client = new ClientConnection().getClient(username, pass);
		PageSet<ObjectInfo> ob= client.listObjects(container);
		
		for (ObjectInfo obInfo:ob) {
			ObjectPo obj =new ObjectPo();
				obj.setName(obInfo.getName());
				obj.setBytes(obInfo.getBytes());
				obj.setContainer(obInfo.getContainer());
				obj.setContentType(obInfo.getContentType());
				obj.setLastModified(time.format(obInfo.getLastModified()).toString());
				obj.setUri(obInfo.getUri().toString());
				list.add(obj);
		}
		return list;
	}

	public List<ObjectPo> getObjMeta(String username, String pass, String containerName, String objName) {
		List<ObjectPo> list = new ArrayList<ObjectPo>();
		SimpleDateFormat time=new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
		SwiftKeystoneClient client = new ClientConnection().getClient(username, pass);
		MutableObjectInfoWithMetadata objMeta =  client.getObjectInfo(containerName, objName);
		ObjectPo obj =new ObjectPo();
		obj.setName(objMeta.getName());
		obj.setBytes(objMeta.getBytes());
		obj.setContainer(objMeta.getContainer());
		obj.setContentType(objMeta.getContentType());
		obj.setLastModified(time.format(objMeta.getLastModified()).toString());
		obj.setUri(objMeta.getUri().toString());
		list.add(obj);
		return list;
	}
	// 创建上传数据对象
	public static SwiftObject newSwiftObject(File data, String key,String username,String pass) throws IOException {
		SwiftKeystoneClient client = new ClientConnection().getClient(username, pass);
		SwiftObject object = client.newSwiftObject();
		object.getInfo().setName(key);
		//File datafile = new File(data);
		object.setPayload(data);
		Payloads.calculateMD5(object);
		object.getInfo().setContentType("text/plain");
		object.getInfo().getMetadata().put("Metadata", "metadata-value");
		return object;
	}
	public boolean uploadFile(String username, String pass, String containerName, File file, String objName){
		SwiftKeystoneClient client = new ClientConnection().getClient(username, pass);
		String result = null;
		try {
			result = client.putObject(containerName, newSwiftObject(file, objName, username, pass));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(result != null){
			return true;
			}else{
		return false;
			}
	}

	public boolean objDownLoad(String username, String pass, String containerName, String objName) {
		SwiftKeystoneClient client = new ClientConnection().getClient(username, pass);
		SwiftObject obj = client.getObject(containerName, objName);
		try {
			InputStream in = obj.getPayload().openStream();
			 File destFile = new File("C:"+File.separator+objName);
			 OutputStream os = new FileOutputStream(destFile);
			 byte[] buffer = new byte[1024];
			 int length = 0;
			 while ((length = in.read(buffer)) > 0) {
				            os.write(buffer, 0, length);
				   }
			 in.close();
	         os.close();
	         return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}



}
