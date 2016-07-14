package com.whoami.sessionHelper;

import org.jclouds.ContextBuilder;
import org.jclouds.openstack.swift.SwiftKeystoneClient;

public class ClientConnection {
	SwiftKeystoneClient client;
	public SwiftKeystoneClient getClient(String username,String pass){
		client=ContextBuilder
				.newBuilder("swift-keystone")
				.credentials(username+":admin",pass)
				.endpoint("http://192.168.244.123:5000/v2.0/")
				.buildApi(SwiftKeystoneClient.class);
		return client;	
	}
}
