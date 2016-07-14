package com.whoami.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.whoami.DAOFactory.DAOFactory;
import com.whomai.po.ContainerMetadataPo;
import com.whomai.po.ObjectPo;
import com.whomai.po.containerPo;

public class action extends supperAction {
	private static final long serialVersionUID = 1L;

	
	public String whoami() throws Exception {
		System.out.println("执行action");
		return SUCCESS;
	}
	public String getAllContainer(){
		List<containerPo> result = DAOFactory.getPersonDAOInstance().getAllContainer("admin", "devstack");
		HttpServletRequest request=ServletActionContext.getRequest();
		//HttpSession session =request.getSession(true);
		request.setAttribute("AllContainer", result);
		return "getAllContainer";
	}
	public String getContainerMeta(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String containerName = request.getParameter("containerName");
		System.out.println("containerName"+containerName);
		List<ContainerMetadataPo> list = DAOFactory.getPersonDAOInstance().getContainermetadata(containerName, "admin", "devstack");
		List<ObjectPo> objList = DAOFactory.getObjectDaoInstance().getAllObject("admin", "devstack", containerName);
		for (ContainerMetadataPo containerMetadataPo : list) {
			Map<String,String> map = containerMetadataPo.getMetadata();
			request.setAttribute("containerDataMap", map);
		}
		request.setAttribute("objList", objList);
		request.setAttribute("containerMeta", list);
		return "getContainerMeta";	
	}
	public String getObjMeta(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String containerName = request.getParameter("containerNameObj");
		String objName = request.getParameter("objName");
		List<ObjectPo> list =DAOFactory.getObjectDaoInstance().getObjMeta("admin", "devstack", containerName, objName);
		request.setAttribute("objMeta", list);
		return "getObjMeta";
		
	}
	public String addContainer(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String containerName = request.getParameter("addContainerName");
		boolean k = DAOFactory.getPersonDAOInstance().createContainer("admin", "devstack", containerName);
		if(k){
			return "addSuccess";
		}else{
			return "addFalse";
		}
	}
	public String getObjDownload(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String containerName = request.getParameter("downContainerNameObj");
		String objName = request.getParameter("downObjName");
		boolean k = DAOFactory.getObjectDaoInstance().objDownLoad("admin", "devstack", containerName, objName);
		if(k){
			return "downSuccess";
		}else{
			return "downFalse";
		}
		}
	public String userLogin(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session =request.getSession(true);
		String username = request.getParameter("u_name");
		String pass = request.getParameter("u_passwd");
		session.setAttribute("sessionName", username);
		if("admin".equals(username)&&"devstack".equals(pass)){
			return "loginSuccess";
		}
		
		return "loginFalse";
		
	}
}
