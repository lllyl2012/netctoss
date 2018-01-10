package cn.tedu.netctoss.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import cn.tedu.netctoss.entity.Account;
import cn.tedu.netctoss.entity.page.AccountPage;
import cn.tedu.netctoss.mapper.AccountMapper;
import cn.tedu.netctoss.mapper.ServiceMapper;

@Controller
@RequestMapping("/account")
//@SessionAttributes("accountPage")
public class AccountController extends BaseController{
	@Resource
	private AccountMapper accountMapper;
	@Resource
	private ServiceMapper serviceMapper;
	/**
	 * 管理所有帐号
	 * @param page
	 * @param map
	 * @return
	 */
	@RequestMapping("/findAccount.do")
	public String find(AccountPage page,ModelMap map) {
		List<Account> list = accountMapper.findByPage(page);
		map.put("accounts", list);
		page.setRows(accountMapper.findRows(page));
		map.put("accountPage", page);
		return "account/account_list";
	}
	/**
	 * 转到更新帐号信息
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("/toUpdateAccount.do")
	public String toUpdate(@RequestParam("id") int id ,ModelMap map) {
		Account account = accountMapper.findById(id);
		map.put("account", account);
		return "account/update_account";
	}
	/**
	 * 更新帐号信息
	 * @param account
	 * @return
	 */
	@RequestMapping("/updateAccount.do")
	public String update(Account account) {
		accountMapper.update(account);
		return "redirect:findAccount.do";
	}
	/**
	 * 锁定帐号
	 * @param id
	 * @return
	 */
	@RequestMapping("/pauseAccount.do")
	public String pause(@RequestParam("id") int id,@RequestParam("status") String status) {
		Account a = new Account();
		a.setAccount_id(id);
		a.setStatus(status);
		accountMapper.updateStatus(a);
		serviceMapper.pauseByAccount(id);
		return "redirect:findAccount.do";
	}
	/**
	 * 转到帐务细节页面
	 */
	@RequestMapping("/addAccountUI.do")
	public String detailAccountUI() {
		return "/account/add_account";
	}
	
	/**
	 * 增加帐务帐号
	 */
	@RequestMapping("/addAccount.do")
	public String addAccount(Account account) {
		account.setStatus("0");
		try {
			accountMapper.insertAccount(account);
			return "redirect:findAccount.do";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
}
