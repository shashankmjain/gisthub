package com.github.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class IssueComment {

private String url;
private String htmlUrl;
private String issueUrl;
private Integer id;
private User user;
private String createdAt;
private String updatedAt;
private String body;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

public String getIssueUrl() {
return issueUrl;
}

public void setIssueUrl(String issueUrl) {
this.issueUrl = issueUrl;
}

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public User getUser() {
return user;
}

public void setUser(User user) {
this.user = user;
}

public String getCreatedAt() {
return createdAt;
}

public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

public String getUpdatedAt() {
return updatedAt;
}

public void setUpdatedAt(String updatedAt) {
this.updatedAt = updatedAt;
}

public String getBody() {
return body;
}

public void setBody(String body) {
this.body = body;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}