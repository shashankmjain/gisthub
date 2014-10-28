package com.github.sonar;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Comment {

@Expose
private String key;
@Expose
private String login;
@Expose
private String htmlText;
@Expose
private String createdAt;

public String getKey() {
return key;
}

public void setKey(String key) {
this.key = key;
}

public String getLogin() {
return login;
}

public void setLogin(String login) {
this.login = login;
}

public String getHtmlText() {
return htmlText;
}

public void setHtmlText(String htmlText) {
this.htmlText = htmlText;
}

public String getCreatedAt() {
return createdAt;
}

public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

}