package com.github.sonar;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class User {

@Expose
private String login;
@Expose
private String name;
@Expose
private Boolean active;
@Expose
private String email;

public String getLogin() {
return login;
}

public void setLogin(String login) {
this.login = login;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Boolean getActive() {
return active;
}

public void setActive(Boolean active) {
this.active = active;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

}