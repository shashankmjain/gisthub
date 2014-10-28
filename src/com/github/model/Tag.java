package com.github.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Tag {

private String name;
private String zipballUrl;
private String tarballUrl;
private Commit commit;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getZipballUrl() {
return zipballUrl;
}

public void setZipballUrl(String zipballUrl) {
this.zipballUrl = zipballUrl;
}

public String getTarballUrl() {
return tarballUrl;
}

public void setTarballUrl(String tarballUrl) {
this.tarballUrl = tarballUrl;
}

public Commit getCommit() {
return commit;
}

public void setCommit(Commit commit) {
this.commit = commit;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}