package com.jdld.util;

import java.util.List;

import com.jdld.entity.Books;
import com.jdld.entity.Manager;
import com.jdld.pageget.Page;

import net.sf.json.JSONObject;
/**
 * @书本信息设置工具类
 * @author q1942
 *
 */
public class SetBookMsgUtil {
	public List<Books> addPage(Page page, List<Books> books, int totalCount) {
		Books bookst = new Books();
		bookst.setBID(page.getCurrentPage() + "");
		bookst.setBNAME(page.isHasPrePage() + "");
		bookst.setAUTHER(page.getBeginIndex() + "");
		bookst.setPRESS(page.isHasNextPage() + "");
		bookst.setPUBLISHTIME(page.getTotalPage() + "");
		bookst.setWORDNUM(totalCount);
		books.add(bookst);
		return books;
	}
	/**
	 * @json数据转换
	 **/
	public JSONObject setObjectType(JSONObject jo, Manager hasManager) {
		jo.put("username", hasManager.getLOGINNAME());
		jo.put("password", hasManager.getLOGINPASS());
		jo.put("loging", hasManager.isLogin());// 登录状态
		jo.put("uid", hasManager.getIDU());
		return jo;
	}
}
