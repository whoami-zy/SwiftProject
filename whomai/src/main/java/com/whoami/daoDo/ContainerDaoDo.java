package com.whoami.daoDo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jclouds.openstack.swift.SwiftKeystoneClient;
import org.jclouds.openstack.swift.domain.ContainerMetadata;

import com.whoami.dao.ContainerDao;
import com.whoami.sessionHelper.ClientConnection;
import com.whomai.po.ContainerMetadataPo;
import com.whomai.po.containerPo;

public class ContainerDaoDo implements ContainerDao {

	public List<containerPo> getAllContainer(String username,String pass) {
		
		List<containerPo> list = new ArrayList<containerPo>();
		SwiftKeystoneClient client = new ClientConnection().getClient(username, pass);
		Set<ContainerMetadata> containers = client.listContainers();
		for (ContainerMetadata containerDate:containers) {
			containerPo container =new containerPo();
				System.out.println(containerDate.getName());
				container.setName(containerDate.getName());
				list.add(container);
		}
		return list;
	}

	public boolean deleteContainer(String containerName) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean setContainermetadata(String containerName, Map<String, String> containermetadata) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<ContainerMetadataPo> getContainermetadata(String containerName,String name,String pass) {
		List<ContainerMetadataPo> list = new ArrayList<ContainerMetadataPo>();
		SwiftKeystoneClient client = new ClientConnection().getClient(name, pass);
		ContainerMetadata meata = client.getContainerMetadata(containerName);
		
			ContainerMetadataPo container =new ContainerMetadataPo();
				
				container.setName(meata.getName());
				container.setCount(meata.getCount());
				container.setBytse(meata.getBytes());
				container.setMetadata(meata.getMetadata());
				list.add(container);
		
		return list;
	}
	public boolean setContainermetadata(String containerName, Map<String, String> containermetadata, String name,
			String pass) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean createContainer(String usename, String pass, String containerName) {
		SwiftKeystoneClient client = new ClientConnection().getClient(usename, pass);
		return client.createContainer(containerName);
	}
}
