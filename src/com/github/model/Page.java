
package com.github.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Page {

private String pageName;
private String title;
private Object summary;
private String action;
private String sha;
private String htmlUrl;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getPageName() {
return pageName;
}

public void setPageName(String pageName) {
this.pageName = pageName;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public Object getSummary() {
return summary;
}

public void setSummary(Object summary) {
this.summary = summary;
}

public String getAction() {
return action;
}

public void setAction(String action) {
this.action = action;
}

public String getSha() {
return sha;
}

public void setSha(String sha) {
this.sha = sha;
}

public String getHtmlUrl() {
return htmlUrl;
}

public void setHtmlUrl(String htmlUrl) {
this.htmlUrl = htmlUrl;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}