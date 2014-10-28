package com.github.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Download {

private String url;
private Integer id;
private String htmlUrl;
private String name;
private String description;
private String createdAt;
private Integer size;
private Integer downloadCount;
private String contentType;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getUrl() {
return url;
}

public void setUrl(String url) {
this.url = url;
}

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getHtmlUrl() {
return htmlUrl;
}

public void setHtmlUrl(String htmlUrl) {
this.htmlUrl = htmlUrl;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public String getCreatedAt() {
return createdAt;
}

public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

public Integer getSize() {
return size;
}

public void setSize(Integer size) {
this.size = size;
}

public Integer getDownloadCount() {
return downloadCount;
}

public void setDownloadCount(Integer downloadCount) {
this.downloadCount = downloadCount;
}

public String getContentType() {
return contentType;
}

public void setContentType(String contentType) {
this.contentType = contentType;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}