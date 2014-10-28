package com.github.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class GistsURL {

private String url;
private String forksUrl;
private String commitsUrl;
private String id;
private String gitPullUrl;
private String gitPushUrl;
private String htmlUrl;
private Files files;
private Boolean _public;
private String createdAt;
private String updatedAt;
private String description;
private Integer comments;
private Object user;
private String commentsUrl;
private Owner owner;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getUrl() {
return url;
}

public void setUrl(String url) {
this.url = url;
}

public String getForksUrl() {
return forksUrl;
}

public void setForksUrl(String forksUrl) {
this.forksUrl = forksUrl;
}

public String getCommitsUrl() {
return commitsUrl;
}

public void setCommitsUrl(String commitsUrl) {
this.commitsUrl = commitsUrl;
}

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getGitPullUrl() {
return gitPullUrl;
}

public void setGitPullUrl(String gitPullUrl) {
this.gitPullUrl = gitPullUrl;
}

public String getGitPushUrl() {
return gitPushUrl;
}

public void setGitPushUrl(String gitPushUrl) {
this.gitPushUrl = gitPushUrl;
}

public String getHtmlUrl() {
return htmlUrl;
}

public void setHtmlUrl(String htmlUrl) {
this.htmlUrl = htmlUrl;
}

public Files getFiles() {
return files;
}

public void setFiles(Files files) {
this.files = files;
}

public Boolean getPublic() {
return _public;
}

public void setPublic(Boolean _public) {
this._public = _public;
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

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public Integer getComments() {
return comments;
}

public void setComments(Integer comments) {
this.comments = comments;
}

public Object getUser() {
return user;
}

public void setUser(Object user) {
this.user = user;
}

public String getCommentsUrl() {
return commentsUrl;
}

public void setCommentsUrl(String commentsUrl) {
this.commentsUrl = commentsUrl;
}

public Owner getOwner() {
return owner;
}

public void setOwner(Owner owner) {
this.owner = owner;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}