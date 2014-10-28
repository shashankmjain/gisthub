package com.github.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Payload {

private List<Page> pages = new ArrayList<Page>();
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public List<Page> getPages() {
return pages;
}

public void setPages(List<Page> pages) {
this.pages = pages;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}