package com.github.sonar;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class SonarIssues {

@Expose
private Boolean securityExclusions;
@Expose
private Boolean maxResultsReached;
@Expose
private Paging paging;
@Expose
private List<Issue> issues = new ArrayList<Issue>();
@Expose
private List<Component> components = new ArrayList<Component>();
@Expose
private List<Project> projects = new ArrayList<Project>();
@Expose
private List<Rule> rules = new ArrayList<Rule>();
@Expose
private List<User> users = new ArrayList<User>();

public Boolean getSecurityExclusions() {
return securityExclusions;
}

public void setSecurityExclusions(Boolean securityExclusions) {
this.securityExclusions = securityExclusions;
}

public Boolean getMaxResultsReached() {
return maxResultsReached;
}

public void setMaxResultsReached(Boolean maxResultsReached) {
this.maxResultsReached = maxResultsReached;
}

public Paging getPaging() {
return paging;
}

public void setPaging(Paging paging) {
this.paging = paging;
}

public List<Issue> getIssues() {
return issues;
}

public void setIssues(List<Issue> issues) {
this.issues = issues;
}

public List<Component> getComponents() {
return components;
}

public void setComponents(List<Component> components) {
this.components = components;
}

public List<Project> getProjects() {
return projects;
}

public void setProjects(List<Project> projects) {
this.projects = projects;
}

public List<Rule> getRules() {
return rules;
}

public void setRules(List<Rule> rules) {
this.rules = rules;
}

public List<User> getUsers() {
return users;
}

public void setUsers(List<User> users) {
this.users = users;
}

}
