package com.whoami.DAOFactory;

import com.whoami.dao.ContainerDao;
import com.whoami.dao.ObjectDao;
import com.whoami.daoDo.ContainerDaoDo;
import com.whoami.daoDo.ObjectDaoDo;

public class DAOFactory {
	public static ContainerDao getPersonDAOInstance()
	{
		return new ContainerDaoDo() ;
	}
	public static ObjectDao getObjectDaoInstance(){
		return new ObjectDaoDo();
	}
}
