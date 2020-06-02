package com.jdld.entity;

import java.util.List;

import com.jdld.pageget.Page;

public class PageList {
	private Page page;
	private List<Books> books;
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<Books> getBooks() {
		return books;
	}
	public void setBooks(List<Books> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "PageList [page=" + page + ", books=" + books + "]";
	}
	public PageList(Page page, List<Books> books) {
		super();
		this.page = page;
		this.books = books;
	}
	public PageList() {
		super();
	}
	
}
