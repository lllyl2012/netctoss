package netctoss.test;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.netctoss.entity.page.ServicePage;
import cn.tedu.netctoss.mapper.AccountMapper;
import cn.tedu.netctoss.mapper.CostMapper;
import cn.tedu.netctoss.mapper.ServiceMapper;

public class TestService {
	AbstractApplicationContext ac;
	ServiceMapper sm;
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("conf/spring-db.xml","conf/spring-mybatis.xml");
		sm = ac.getBean("serviceMapper",ServiceMapper.class);
	}
	@After
	public void destory() {
		ac.close();
	}
	@Test
	public void testServiceFindRows() {
		ServicePage sp = new ServicePage();
		sp.setIdcard_no("123321");
		Integer num = sm.findRows(sp);
		System.out.println(num);
	}
	@Test
	public void testFindByPage() {
		ServicePage sp = new ServicePage();
		List<Map<String,Object>> list = sm.findByPage(sp);
		for (Map<String, Object> map : list) {
			for (Entry<String,Object> entry : map.entrySet()) {
				System.out.println(entry);
			}
		}
	}
}
