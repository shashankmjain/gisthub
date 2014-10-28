package com.github.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Event {

private String id;
private String type;
private Actor actor;
private Repo repo;
private Payload payload;
private Boolean _public;
private String createdAt;
private Org org;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public Actor getActor() {
return actor;
}

public void setActor(Actor actor) {
this.actor = actor;
}

public Repo getRepo() {
return repo;
}

public void setRepo(Repo repo) {
this.repo = repo;
}

public Payload getPayload() {
return payload;
}

public void setPayload(Payload payload) {
this.payload = payload;
}

public Boolean getPublic() {
return _public;
}

public void setPublic(Boolean _public) {
this._public = _public;
}

public String getCreatedAt() {
return createdAt;
}

public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

public Org getOrg() {
return org;
}

public void setOrg(Org org) {
this.org = org;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}