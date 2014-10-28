package com.github.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Content {

private String name;
private String path;
private String sha;
private Integer size;
private String url;
private String htmlUrl;
private String gitUrl;
private String type;
private Links links;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getPath() {
return path;
}

public void setPath(String path) {
this.path = path;
}

public String getSha() {
return sha;
}

public void setSha(String sha) {
this.sha = sha;
}

public Integer getSize() {
return size;
}

public void setSize(Integer size) {
this.size = size;
}

public String getUrl() {
return url;
}

public void setUrl(String url) {
this.url = url;
}

public String getHtmlUrl() {
return htmlUrl;
}

public void setHtmlUrl(String htmlUrl) {
this.htmlUrl = htmlUrl;
}

public String getGitUrl() {
return gitUrl;
}

public void setGitUrl(String gitUrl) {
this.gitUrl = gitUrl;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public Links getLinks() {
return links;
}

public void setLinks(Links links) {
this.links = links;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}