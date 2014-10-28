package com.github.sonar;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Project {

@Expose
private String key;
@Expose
private String qualifier;
@Expose
private String name;
@Expose
private String longName;

public String getKey() {
return key;
}

public void setKey(String key) {
this.key = key;
}

public String getQualifier() {
return qualifier;
}

public void setQualifier(String qualifier) {
this.qualifier = qualifier;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getLongName() {
return longName;
}

public void setLongName(String longName) {
this.longName = longName;
}

}