package cn.tedu.netctoss.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.netctoss.entity.Account;
import cn.tedu.netctoss.entity.Cost;
import cn.tedu.netctoss.entity.Host;
import cn.tedu.netctoss.entity.ResponseResult;
import cn.tedu.netctoss.entity.Service;
import cn.tedu.netctoss.entity.ServiceUpdateBak;
import cn.tedu.netctoss.entity.page.ServicePage;
import cn.tedu.netctoss.mapper.AccountMapper;
import cn.tedu.netctoss.mapper.CostMapper;
import cn.tedu.netctoss.mapper.HostMapper;
import cn.tedu.netctoss.mapper.ServiceMapper;
import cn.tedu.netctoss.mapper.ServiceUpdateBakMapper;

@Controller
@RequestMapping("/service")
public class ServiceController extends BaseController{
	@Resource
	private ServiceMapper serviceMapper;
	@Resource
	private AccountMapper accountMapper;
	@Resource
	private CostMapper costMapper;
	@Resource
	private HostMapper hostMapper;
	@Resource
	private ServiceUpdateBakMapper serviceUpdateBakMapper;
	/**
	 * 前往业务管理界面
	 * @param res
	 * @param page
	 * @param map
	 * @return
	 */
	@RequestMapping("/findService.do")
	public String find(HttpServletResponse res,ServicePage page,ModelMap map) {
		List<Map<String,Object>> list = serviceMapper.findByPage(page);
		map.put("services", list);
		page.setRows(serviceMapper.findRows(page));
		map.put("servicePage", page);
//		String p = String.valueOf(page.getPage());
//		Cookie cookie = new Cookie("page",p);
//		res.addCookie(cookie);
		return "service/service_list";
	}
	/**
	 * 开通业务
	 * @param id
	 * @return
	 */
	@RequestMapping("/startService.do")
	@ResponseBody
	public Map<String,Object> startService(@RequestParam("id") Integer id) {
		Map<String,Object> map = new HashMap<String,Object>();
		Service service = serviceMapper.findById(id);
		Account account = accountMapper.findById(service.getAccount_id());
		Cost cost = costMapper.findCostById(service.getCost_id());
		if(!account.getStatus().equals("0")) {
			map.put("message", "该帐号已被锁定，不能开通业务");
			map.put("success", false);
			return map;
		}
		if(!cost.getStatus().equals("0")) {
			map.put("message", "该套餐活动已经结束，无法办理");
			map.put("success", false);
			return map;
		}
		service.setStatus("0");
		try {
			serviceMapper.updateStatus(service);
			map.put("message", "成功开通");
			map.put("success", true);
		} catch (Exception e) {
			map.put("message", "发生异常，开通失败");
			map.put("success", false);
		}
		return map;
	}
	/**
	 * 暂停业务
	 * @param id
	 * @return
	 */
	@RequestMapping("/pauseService.do")
	@ResponseBody
	public Map<String,Object> pauseService(@RequestParam("id") Integer id){
		Map<String,Object> map = new HashMap<String,Object>();
		Service service = serviceMapper.findById(id);
		service.setStatus("1");
		try {
			serviceMapper.updateStatus(service);
			map.put("message", "已终止该项服务");
			map.put("success", true);
		} catch (Exception e) {
			map.put("message", "未知错误，,终止该项服务");
			map.put("success", false);
		}
		return map;
	}
	/**
	 * 前往添加业务界面
	 * @return
	 */
	@RequestMapping("/toAddService.do")
	public String toAddService(ModelMap map) {
		List<Cost> list = costMapper.findAll();
		map.put("costs", list);
		List<Host> list2 = hostMapper.findALlHosts();
		map.put("hosts", list2);
		return "/service/add_service";
	}
	
	/**
	 * 检查该身份证是否已经开通此业务，并返回帐号信息
	 */
	@RequestMapping("/searchAccount.do")
	@ResponseBody
	public Account searchAccount(@RequestParam("idcard_no") String idcard_no){
		Account account = accountMapper.selectAccountByIdcardNo(idcard_no);
		return account;
	}
	
	/**
	 * 办理该账户的业务
	 */
	@RequestMapping("/addService.do")
	@ResponseBody
	public ResponseResult<Void> addService(Service service) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		try {
			serviceMapper.insertAddService(service);
			rr.setState(ResponseResult.STATE_OK);
			rr.setMessage("添加成功");
			return rr;
		} catch (Exception e) {
			e.printStackTrace();
			rr.setState(ResponseResult.STATE_ERROR);
			rr.setMessage("添加失败");
			return rr;
		}
	}
	
	/**
	 *前往修改业务内容页面
	 */
	@RequestMapping("/toUpdateService.do")
	public String toUpdateService(Integer id,String os_username,ModelMap map) {
		Service service = serviceMapper.findById(id);
		map.put("service", service);
//		map.put("service_id", id);
//		map.put("os_username", os_username);
//		List<Host> hosts = hostMapper.findALlHosts();
		List<Cost> costs = costMapper.findAll();
		map.put("costs", costs);
//		map.put("hosts", hosts);
		return "/service/update_service";
	}
	
	/**
	 * 修改业务内容,下个月生效
	 */
	@RequestMapping("/updateService.do")
	@ResponseBody
	public ResponseResult<Void> updateService(ServiceUpdateBak serviceUpdateBak){
		ResponseResult<Void> rr = new ResponseResult<Void>();
		try {
			serviceUpdateBakMapper.insertServiceUpdateBak(serviceUpdateBak);
			rr.setState(ResponseResult.STATE_OK);
			rr.setMessage("修改成功，下个月生效");
		} catch (Exception e) {
			e.printStackTrace();
			rr.setState(ResponseResult.STATE_ERROR);
			rr.setMessage("修改失败");
		}
		return rr;
	}
}

