package com.github.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class IssueEvent {

private Integer id;
private String url;
private Actor actor;
private String event;
private Object commitId;
private String createdAt;
private Issue issue;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getUrl() {
return url;
}

public void setUrl(String url) {
this.url = url;
}

public Actor getActor() {
return actor;
}

public void setActor(Actor actor) {
this.actor = actor;
}

public String getEvent() {
return event;
}

public void setEvent(String event) {
this.event = event;
}

public Object getCommitId() {
return commitId;
}

public void setCommitId(Object commitId) {
this.commitId = commitId;
}

public String getCreatedAt() {
return createdAt;
}

public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

public Issue getIssue() {
return issue;
}

public void setIssue(Issue issue) {
this.issue = issue;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}