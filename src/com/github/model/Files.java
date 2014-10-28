package com.github.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Files {

private Gistfile1Java gistfile1Java;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Gistfile1Java getGistfile1Java() {
return gistfile1Java;
}

public void setGistfile1Java(Gistfile1Java gistfile1Java) {
this.gistfile1Java = gistfile1Java;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}