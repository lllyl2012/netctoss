package cn.tedu.netctoss.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.netctoss.annotation.MyBatisRepository;
import cn.tedu.netctoss.entity.Service;
import cn.tedu.netctoss.entity.page.Page;

public interface ServiceMapper {
	/**
	 * 暂停该帐号下所有业务帐号
	 * @param accountId
	 */
	void pauseByAccount(@Param("accountId") int accountId);
	/**
	 * 查询指定业务帐号
	 */
	Integer findRows(Page page);
	/**
	 * 业务帐号分页查询
	 */
	List<Map<String,Object>> findByPage(Page page);
	/**
	 * 更改业务状态
	 */
	void updateStatus(Service service);
	/**
	 * 根据id查询业务
	 */
	Service findById(@Param("service_id") int service_id);
	/**
	 * 办理业务
	 */
	Integer insertAddService(Service service);
}
