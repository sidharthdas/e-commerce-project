package com.ecommerce.dto;

import java.util.HashMap;
import java.util.Map;

import com.ecommerce.enums.SEARCH_TYPE;

public class SearchForm {

	private SEARCH_TYPE searchType;

	public SEARCH_TYPE getSearchType() {
		return searchType;
	}

	public void setSearchType(SEARCH_TYPE searchType) {
		this.searchType = searchType;
	}

	public Map<String, Object> getSearchParams() {
		return searchParams;
	}

	public void setSearchParams(Map<String, Object> searchParams) {
		this.searchParams = searchParams;
	}

	private Map<String, Object> searchParams = new HashMap<>();

}
