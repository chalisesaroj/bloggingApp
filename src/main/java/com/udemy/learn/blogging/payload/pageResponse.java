package com.udemy.learn.blogging.payload;

import java.util.List;

import com.udemy.learn.blogging.entity.Post;

public class PageResponse {
	List<PostDto> contents;
	int pageNumber;
	int pageSize;
	int noOfPage;
	int noOfElements;
	

	public int getNoOfElements() {
		return noOfElements;
	}
	public void setNoOfElements(int noOfElements) {
		this.noOfElements = noOfElements;
	}
	
	public List<PostDto> getContents() {
		return contents;
	}
	public void setContents(List<PostDto> contents) {
		this.contents = contents;
	}

	boolean isLast;
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getNoOfPage() {
		return noOfPage;
	}
	public void setNoOfPage(int noOfPage) {
		this.noOfPage = noOfPage;
	}
	public boolean isLast() {
		return isLast;
	}
	public void setLast(boolean isLast) {
		this.isLast = isLast;
	}
	

}
