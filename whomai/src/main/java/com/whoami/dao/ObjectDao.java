package com.whoami.dao;

import java.io.File;
import java.util.List;

import com.whomai.po.ObjectPo;

public interface ObjectDao {
	public List<ObjectPo> getAllObject(String username,String pass,String container);
	public List<ObjectPo> getObjMeta(String username,String pass,String containerName,String objName);
	public boolean uploadFile(String username,String pass,String  containerName,File file,String objName);
	public boolean objDownLoad(String username,String pass,String  containerName,String objName);
}
