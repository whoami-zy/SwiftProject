package com.whomai.po;

public class ObjectPo {
private String name;
private String container;
private String uri;
private long bytes;
private String contentType;
private String lastModified;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getContainer() {
	return container;
}
public void setContainer(String container) {
	this.container = container;
}
public String getUri() {
	return uri;
}
public void setUri(String uri) {
	this.uri = uri;
}
public long getBytes() {
	return bytes;
}
public void setBytes(long bytes) {
	this.bytes = bytes;
}
public String getContentType() {
	return contentType;
}
public void setContentType(String contentType) {
	this.contentType = contentType;
}
public String getLastModified() {
	return lastModified;
}
public void setLastModified(String lastModified) {
	this.lastModified = lastModified;
}

}
