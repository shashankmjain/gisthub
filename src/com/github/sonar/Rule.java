package com.github.sonar;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Rule {

@Expose
private String key;
@Expose
private String name;
@Expose
private String desc;
@Expose
private String status;

public String getKey() {
return key;
}

public void setKey(String key) {
this.key = key;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getDesc() {
return desc;
}

public void setDesc(String desc) {
this.desc = desc;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

}