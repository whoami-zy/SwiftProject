package com.whoami.dao;

import java.util.List;
import java.util.Map;

import com.whomai.po.ContainerMetadataPo;
import com.whomai.po.containerPo;


public interface ContainerDao {
	public List<containerPo> getAllContainer(String username,String pass);
	public boolean createContainer(String usename,String pass ,String containerName);
	public boolean deleteContainer(String containerName);
	//查看容器元数据
	public List<ContainerMetadataPo> getContainermetadata(String containerName,String username,String pass);
	//设置元数据
	public boolean setContainermetadata(String containerName, Map<String, String> containermetadata,String name,String pass);
}
 