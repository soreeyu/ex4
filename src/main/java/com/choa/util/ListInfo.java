package com.choa.util;

public class ListInfo {

	private Integer curPage;
	private Integer perPage;
	private String search;
	private String kind;
	
	//RowMaker
	private int startRow;
	private int lastRow;
	
	//PageResult
	private int curBlock;
	private int totalBlock;
	private int startNum;
	private int lastNum;
	
	
	
	
	public int getStartRow() {
		return startRow;
	}
	public int getLastRow() {
		return lastRow;
	}
	
	public Integer getCurPage() {
		if(curPage == null){
			curPage =1;
		}
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		
		this.curPage = curPage;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public Integer getPerPage() {
		if(perPage == null){
			perPage =10;
		}
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	
	//MakeRow
	public void setRow(){
		startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		lastRow = this.getCurPage()*this.getPerPage();
	}
	
	
	
	
	public int getCurBlock() {
		return curBlock;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public int getStartNum() {
		return startNum;
	}
	public int getLastNum() {
		return lastNum;
	}
	//PageResult
	public void makePage(int totalCount){
		//1. totalPage
		int totalPage = 0;
		int perBlock = 5;
		if(totalCount % this.getPerPage() == 0){
			totalPage = totalCount/this.getPerPage();
		}else{
			totalPage = totalCount/this.getPerPage()+1;
		}
		//2.totalBlock
		if(totalPage%perBlock == 0){
			totalBlock = totalPage/perBlock;
		}else{
			totalBlock = totalPage/perBlock+1;
		}
		//3. curBlock
		if(this.getCurPage()%perBlock == 0){
			this.curBlock = this.getCurPage()/perBlock;
		}else{
			this.curBlock = this.getCurPage() /perBlock +1;
		}
		//4. startNum, lastNum
		startNum = (curBlock-1)*perBlock+1;
		lastNum = curBlock*perBlock;
		if(totalBlock == curBlock){
			lastNum =totalPage;
		}else if(totalBlock < 1){
			lastNum = 1;
		}
		
		
	}
	
}
