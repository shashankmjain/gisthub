package com.github.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class PullRequest {

private String url;
private String htmlUrl;
private String diffUrl;
private String patchUrl;
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

public String getDiffUrl() {
return diffUrl;
}

public void setDiffUrl(String diffUrl) {
this.diffUrl = diffUrl;
}

public String getPatchUrl() {
return patchUrl;
}

public void setPatchUrl(String patchUrl) {
this.patchUrl = patchUrl;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}