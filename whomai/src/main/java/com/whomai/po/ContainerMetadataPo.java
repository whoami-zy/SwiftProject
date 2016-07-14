package com.whomai.po;

import java.util.Map;

public class ContainerMetadataPo {
private String name;
private long count;
private Map<String,String> metadata;
private long bytse;
public long getBytse() {
	return bytse;
}
public void setBytse(long bytse) {
	this.bytse = bytse;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getCount() {
	return count;
}
public void setCount(long count) {
	this.count = count;
}
public Map<String, String> getMetadata() {
	return metadata;
}
public void setMetadata(Map<String, String> metadata) {
	this.metadata = metadata;
}

}
