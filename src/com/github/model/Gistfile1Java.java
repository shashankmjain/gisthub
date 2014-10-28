package com.github.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Gistfile1Java {

private String filename;
private String type;
private String language;
private String rawUrl;
private Integer size;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getFilename() {
return filename;
}

public void setFilename(String filename) {
this.filename = filename;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getLanguage() {
return language;
}

public void setLanguage(String language) {
this.language = language;
}

public String getRawUrl() {
return rawUrl;
}

public void setRawUrl(String rawUrl) {
this.rawUrl = rawUrl;
}

public Integer getSize() {
return size;
}

public void setSize(Integer size) {
this.size = size;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}