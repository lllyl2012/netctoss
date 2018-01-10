package cn.tedu.netctoss.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.netctoss.annotation.MyBatisRepository;
import cn.tedu.netctoss.entity.Cost;
import cn.tedu.netctoss.entity.page.Page;
@MyBatisRepository
public interface CostMapper {
	/**
	 * 找到所有资费列表
	 * @return
	 */
	List<Cost> findAll();
	/**
	 * 修改资费状态
	 */
	Integer updateStatusCostById(Cost cost);
	/**
	 * 找到对应页所含的行数
	 */
	Integer findRows(Page page);
	/**
	 * 根据id查找资费
	 */
	Cost findCostById(@Param("cost_id") int cost_id);
	/**
	 * 增加资费项目
	 */
	Integer insertCost(Cost cost);
	/**
	 * 修改资费
	 */
	Integer updateCost(Cost cost);
}
