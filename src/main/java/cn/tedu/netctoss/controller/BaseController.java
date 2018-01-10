package cn.tedu.netctoss.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import cn.tedu.netctoss.util.DateEditor;


public class BaseController {
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(java.sql.Date.class, new DateEditor());
	}
	protected String isoToUtf8(String s) {
		if(s==null)
				return null;
		try {
			return new String(s.getBytes("ISO8859-1"),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
