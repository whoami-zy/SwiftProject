package com.whoami.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.whoami.DAOFactory.DAOFactory;
import com.whomai.po.ObjectPo;

public class ObjectAction extends supperAction{

	private static final long serialVersionUID = 1L;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private String dataUrl;
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getDataUrl() {
		return dataUrl;
	}
	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}
	public String getObjMeta(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String containerName = request.getParameter("container");
		
		String objName = request.getParameter("objName");
		List<ObjectPo> list =DAOFactory.getObjectDaoInstance().getObjMeta("admin", "devstack", containerName, objName);
		request.setAttribute("objMeta", list);
		return "getObjMeta";
		
	}
	public String uploadFile()  throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String containerName = request.getParameter("containerNameObj");
		System.out.println("containerName------------------"+containerName);
		String objName=this.getFileFileName();
		boolean k = DAOFactory.getObjectDaoInstance().uploadFile("admin", "devstack", containerName, file, objName);
		if(k){	  
		return "success";
		}else{
		return "false";
		}
			            	 
		
	}
}

