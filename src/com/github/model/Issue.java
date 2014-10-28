package com.github.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Issue {

private String url;
private String labelsUrl;
private String commentsUrl;
private String eventsUrl;
private String htmlUrl;
private Integer id;
private Integer number;
private String title;
private User user;
private List<Object> labels = new ArrayList<Object>();
private String state;
private Boolean locked;
private Object assignee;
private Object milestone;
private Integer comments;
private String createdAt;
private String updatedAt;
private String closedAt;
private PullRequest pullRequest;
private String body;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getUrl() {
return url;
}

public void setUrl(String url) {
this.url = url;
}

public String getLabelsUrl() {
return labelsUrl;
}

public void setLabelsUrl(String labelsUrl) {
this.labelsUrl = labelsUrl;
}

public String getCommentsUrl() {
return commentsUrl;
}

public void setCommentsUrl(String commentsUrl) {
this.commentsUrl = commentsUrl;
}

public String getEventsUrl() {
return eventsUrl;
}

public void setEventsUrl(String eventsUrl) {
this.eventsUrl = eventsUrl;
}

public String getHtmlUrl() {
return htmlUrl;
}

public void setHtmlUrl(String htmlUrl) {
this.htmlUrl = htmlUrl;
}

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public Integer getNumber() {
return number;
}

public void setNumber(Integer number) {
this.number = number;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public User getUser() {
return user;
}

public void setUser(User user) {
this.user = user;
}

public List<Object> getLabels() {
return labels;
}

public void setLabels(List<Object> labels) {
this.labels = labels;
}

public String getState() {
return state;
}

public void setState(String state) {
this.state = state;
}

public Boolean getLocked() {
return locked;
}

public void setLocked(Boolean locked) {
this.locked = locked;
}

public Object getAssignee() {
return assignee;
}

public void setAssignee(Object assignee) {
this.assignee = assignee;
}

public Object getMilestone() {
return milestone;
}

public void setMilestone(Object milestone) {
this.milestone = milestone;
}

public Integer getComments() {
return comments;
}

public void setComments(Integer comments) {
this.comments = comments;
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

public String getClosedAt() {
return closedAt;
}

public void setClosedAt(String closedAt) {
this.closedAt = closedAt;
}

public PullRequest getPullRequest() {
return pullRequest;
}

public void setPullRequest(PullRequest pullRequest) {
this.pullRequest = pullRequest;
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