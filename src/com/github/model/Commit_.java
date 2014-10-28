package com.github.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Commit_ {

private Author author;
private Committer committer;
private String message;
private Tree tree;
private String url;
private Integer commentCount;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Author getAuthor() {
return author;
}

public void setAuthor(Author author) {
this.author = author;
}

public Committer getCommitter() {
return committer;
}

public void setCommitter(Committer committer) {
this.committer = committer;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public Tree getTree() {
return tree;
}

public void setTree(Tree tree) {
this.tree = tree;
}

public String getUrl() {
return url;
}

public void setUrl(String url) {
this.url = url;
}

public Integer getCommentCount() {
return commentCount;
}

public void setCommentCount(Integer commentCount) {
this.commentCount = commentCount;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}