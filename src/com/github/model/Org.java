package com.github.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Org {

private Integer id;
private String login;
private String gravatarId;
private String url;
private String avatarUrl;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getLogin() {
return login;
}

public void setLogin(String login) {
this.login = login;
}

public String getGravatarId() {
return gravatarId;
}

public void setGravatarId(String gravatarId) {
this.gravatarId = gravatarId;
}

public String getUrl() {
return url;
}

public void setUrl(String url) {
this.url = url;
}

public String getAvatarUrl() {
return avatarUrl;
}

public void setAvatarUrl(String avatarUrl) {
this.avatarUrl = avatarUrl;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}