package com.github.sonar;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Issue {

@Expose
private String key;
@Expose
private String component;
@Expose
private String project;
@Expose
private String rule;
@Expose
private String status;
@Expose
private String resolution;
@Expose
private String severity;
@Expose
private String message;
@Expose
private Integer line;
@Expose
private String author;
@Expose
private String creationDate;
@Expose
private String updateDate;
@Expose
private List<Comment> comments = new ArrayList<Comment>();

public String getKey() {
return key;
}

public void setKey(String key) {
this.key = key;
}

public String getComponent() {
return component;
}

public void setComponent(String component) {
this.component = component;
}

public String getProject() {
return project;
}

public void setProject(String project) {
this.project = project;
}

public String getRule() {
return rule;
}

public void setRule(String rule) {
this.rule = rule;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getResolution() {
return resolution;
}

public void setResolution(String resolution) {
this.resolution = resolution;
}

public String getSeverity() {
return severity;
}

public void setSeverity(String severity) {
this.severity = severity;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public Integer getLine() {
return line;
}

public void setLine(Integer line) {
this.line = line;
}

public String getAuthor() {
return author;
}

public void setAuthor(String author) {
this.author = author;
}

public String getCreationDate() {
return creationDate;
}

public void setCreationDate(String creationDate) {
this.creationDate = creationDate;
}

public String getUpdateDate() {
return updateDate;
}

public void setUpdateDate(String updateDate) {
this.updateDate = updateDate;
}

public List<Comment> getComments() {
return comments;
}

public void setComments(List<Comment> comments) {
this.comments = comments;
}

}