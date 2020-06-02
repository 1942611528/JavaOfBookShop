package com.jdld.pageget.pagegetutil;

import com.jdld.pageget.Page;

/**
 * @author q1942
 *   分页信息辅助类
 *   用于计算页码与容量
 */
public class PageUtil {
	//创建Page对象
	public static Page createPage(int everyPage,int totalCount,int currentPage) {
		
		everyPage = getEveryPage(everyPage);//每一页显示的记录数
        currentPage = getCurrentPage(currentPage);//获取当前页
        int totalPage = getTotalPage(everyPage, totalCount);//获取总页数
        int beginIndex = getBeginIndex(everyPage, currentPage);//获取每页开始位置
        int endIndex=getEndIndex(everyPage, currentPage);//获取每页结束位置
        boolean hasPrePage = getHasPrePage(currentPage);//获取是否有上一页
        boolean hasNextPage = getHasNextPage(totalPage, currentPage);//获取是否有下一页
        //页数信息集合
        return new Page(everyPage, totalCount, totalPage, currentPage,
                beginIndex,endIndex, hasPrePage,  hasNextPage);
	}
	//一下方法辅助创建Page对象
	//获得是否有上一页
	private static boolean getHasNextPage(int totalPage, int currentPage) {
		return currentPage == totalPage || totalPage ==0 ?false:true;
	}
	//获得是否有上一页
	private static boolean getHasPrePage(int currentPage) {
		return currentPage == 1?false:true;
	}
	//获取起始位置
	private static int getBeginIndex(int everyPage, int currentPage) {
		return (currentPage - 1)*everyPage+1;
	}
	//获取每页的结束位置
	private static int getEndIndex(int everyPage, int currentPage) {
		return currentPage*everyPage;
	}
	//获取每一页显示的记录数
	public static int getEveryPage(int everyPage) {
		return everyPage ==0?10:everyPage;
	}
	//获取当前页
	private static int getCurrentPage(int currentPage) {
		return currentPage ==0?1:currentPage;
	}
	//获取总页数
	private static int getTotalPage(int everyPage, int totalCount) {
		int totalPage=0;//存放当前总页面
		if(totalCount !=0 && totalCount % everyPage == 0) {
			//总页数/每一页显示数量
			totalPage=totalCount/everyPage;
		}else {
			totalPage=totalCount/everyPage+1;
		}
		return totalPage;
	}
}
