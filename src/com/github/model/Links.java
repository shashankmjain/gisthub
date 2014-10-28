package com.github.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Links {

private String self;
private String git;
private String html;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getSelf() {
return self;
}

public void setSelf(String self) {
this.self = self;
}

public String getGit() {
return git;
}

public void setGit(String git) {
this.git = git;
}

public String getHtml() {
return html;
}

public void setHtml(String html) {
this.html = html;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}