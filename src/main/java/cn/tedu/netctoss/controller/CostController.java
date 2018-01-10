package cn.tedu.netctoss.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.naming.spi.ResolveResult;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import cn.tedu.netctoss.entity.Cost;
import cn.tedu.netctoss.entity.ResponseResult;
import cn.tedu.netctoss.entity.page.CostPage;
import cn.tedu.netctoss.mapper.CostMapper;

@Controller
@RequestMapping("/cost")
//@SessionAttributes("costPage")
public class CostController extends BaseController{
	@Resource
	private CostMapper costMapper;
	/**
	 * 查询资费表
	 * @param map
	 * @return
	 */
	@RequestMapping("/findCost.do")
	public String find(CostPage page,ModelMap map) {
		List<Cost> list = costMapper.findAll();
		map.put("costs", list);
		page.setRows(costMapper.findRows(page));
		map.put("costPage", page);
		return "cost/cost_list";
	}
	/**
	 * 开启或暂停资费
	 */
	@RequestMapping("/updateStatus.do")
	@ResponseBody
	public ResponseResult<String> updateStatus(Cost cost) {
		Integer num = costMapper.updateStatusCostById(cost);
		ResponseResult<String> rr = new ResponseResult<String>();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nowTime = sdf.format(now);
		if("0".equals(cost.getStatus())) {
			rr.setState(1);
			rr.setMessage("开通");
			rr.setData(nowTime);
		}else {
			rr.setState(-1);
			rr.setMessage("暂停");
		}
		System.out.println("rr:"+rr);
		return rr;
	}
	
	/**
	 *前往 增加资费项目页面
	 */
	@RequestMapping("/toAddCost.do")
	public String toAddCost() {
		return "/cost/add_cost";
	}

	/**
	 *前往修改资费项目页面
	 */
	@RequestMapping("/toUpdateCost.do")
	public String toUpdateCost(Integer id,ModelMap map) {
		Cost cost = costMapper.findCostById(id);
		map.put("cost", cost);
		return "/cost/update_cost";
	}
	
	/**
	 * 增加资费项目
	 */
	@RequestMapping("/addCost.do")
	public String addCost(Cost cost) {
		try {
			costMapper.insertCost(cost);
			return "redirect:findCost.do";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * 修改资费项目
	 */
	@RequestMapping("/updateCost.do")
	public String updateCost(Cost cost) {
		try {
			cost.setDescr(cost.getDescr().trim());
			costMapper.updateCost(cost);
			return "redirect:findCost.do";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
