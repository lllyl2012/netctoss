package netctoss.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.netctoss.entity.Account;
import cn.tedu.netctoss.entity.Cost;
import cn.tedu.netctoss.entity.Service;
import cn.tedu.netctoss.entity.page.AccountPage;
import cn.tedu.netctoss.entity.page.Page;
import cn.tedu.netctoss.entity.page.ServicePage;
import cn.tedu.netctoss.mapper.AccountMapper;
import cn.tedu.netctoss.mapper.CostMapper;
import cn.tedu.netctoss.mapper.ServiceMapper;

public class TestMapper {
	AbstractApplicationContext ac;
	CostMapper costMapper;
	AccountMapper accountMapper;
	ServiceMapper serviceMapper;
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("conf/spring-db.xml","conf/spring-mybatis.xml");
		costMapper = ac.getBean("costMapper",CostMapper.class);
		accountMapper = ac.getBean("accountMapper",AccountMapper.class);
		serviceMapper = ac.getBean("serviceMapper",ServiceMapper.class);
	}
	@After
	public void destory() {
		ac.close();
	}
	@Test
	public void testCostMapper() {
		List<Cost> list = costMapper.findAll();
		for (Cost cost : list) {
			System.out.println(cost);
			
		}
	}
	@Test
	public void testAccountMapper() {
		AccountPage page = new AccountPage();
		page.setLogin_name("tom");
		page.setPage(1);
		page.getBegin();
		page.setPageSize(5);
		int a = accountMapper.findRows(page);
		System.out.println(a);
		List<Account> list = accountMapper.findByPage(page);
		for (Account account : list) {
			System.out.println(account);
			
		}
	}
	@Test
	public void testFindById() {
		Account ac = accountMapper.findById(2);
		System.out.println(ac);
	}
	@Test
	public void testUpdateAccountStatus() {
		Account a = new Account();
		a.setAccount_id(2);
		a.setStatus("1");
		System.out.println(a);
		accountMapper.updateStatus(a);
	}
	@Test
	public void testPauseByAccount() {
		Account a = new Account();
		a.setAccount_id(2);
		a.setStatus("1");
		serviceMapper.pauseByAccount(2);
	}
	@Test
	public void testFindServiceById() {
		Service service = serviceMapper.findById(5);
		System.out.println(service);
	}
	@Test
	public void testUpdateServiceStatus() {
		Service service = new Service();
		service.setService_id(5);
		service.setStatus("0");
		serviceMapper.updateStatus(service);
		System.out.println("ok");
	}
	@Test
	public void testFindCostById() {
		Cost cost = costMapper.findCostById(2);
		System.out.println(cost);
	}
	@Test
	public void testFindRows() {
		ServicePage page = new ServicePage();
		page.setStatus("1");
		page.setIdcard_no("123321");
		int num = serviceMapper.findRows(page);
		System.out.println(num);
	}
	@Test
	public void testAddAccount() {
		Account account  = new Account();
		account.setLogin_name("soft");
		account.setLogin_passwd("333333");
		account.setStatus("0");
		Date date = new Date();
		account.setCreate_date(new Timestamp(date.getTime()));
		account.setReal_name("monaka");
		account.setIdcard_no("595959");
		account.setGender("0");
		account.setTelephone("135999");
		accountMapper.insertAccount(account);
		System.out.println("end");
	}
	
	@Test
	public void testAddCost() {
		Cost cost = new Cost();
	}
}
