package com.github.sonar;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Paging {

@Expose
private Integer pageIndex;
@Expose
private Integer pageSize;
@Expose
private Integer total;
@Expose
private Integer pages;

public Integer getPageIndex() {
return pageIndex;
}

public void setPageIndex(Integer pageIndex) {
this.pageIndex = pageIndex;
}

public Integer getPageSize() {
return pageSize;
}

public void setPageSize(Integer pageSize) {
this.pageSize = pageSize;
}

public Integer getTotal() {
return total;
}

public void setTotal(Integer total) {
this.total = total;
}

public Integer getPages() {
return pages;
}

public void setPages(Integer pages) {
this.pages = pages;
}

}