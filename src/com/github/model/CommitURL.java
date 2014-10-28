package com.github.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class CommitURL {

private String sha;
private Commit_ commit;
private String url;
private String htmlUrl;
private String commentsUrl;
private Author_ author;
private Committer_ committer;
private List<Parent> parents = new ArrayList<Parent>();
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getSha() {
return sha;
}

public void setSha(String sha) {
this.sha = sha;
}

public Commit_ getCommit() {
return commit;
}

public void setCommit(Commit_ commit) {
this.commit = commit;
}

public String getUrl() {
return url;
}

public void setUrl(String url) {
this.url = url;
}

public String getHtmlUrl() {
return htmlUrl;
}

public void setHtmlUrl(String htmlUrl) {
this.htmlUrl = htmlUrl;
}

public String getCommentsUrl() {
return commentsUrl;
}

public void setCommentsUrl(String commentsUrl) {
this.commentsUrl = commentsUrl;
}

public Author_ getAuthor() {
return author;
}

public void setAuthor(Author_ author) {
this.author = author;
}

public Committer_ getCommitter() {
return committer;
}

public void setCommitter(Committer_ committer) {
this.committer = committer;
}

public List<Parent> getParents() {
return parents;
}

public void setParents(List<Parent> parents) {
this.parents = parents;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}