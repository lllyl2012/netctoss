package cn.tedu.netctoss.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.netctoss.annotation.MyBatisRepository;
import cn.tedu.netctoss.entity.Account;
import cn.tedu.netctoss.entity.page.Page;

@MyBatisRepository
public interface AccountMapper {
	/**
	 *查找当前页的用户信息
	 * @param page
	 * @return
	 */
	List<Account> findByPage(Page page);
	/**
	 * 查找当前页的行数
	 * @param page
	 * @return
	 */
	int findRows(Page page);
	/**
	 * 根据id查找帐务
	 */
	Account findById(@Param("account_id") int account_id);
	/**
	 * 修改帐务
	 */
	Integer update(Account account);
	/**
	 * 修改帐号状态
	 */
	void updateStatus(Account account);
	/**
	 * 增加帐务帐号
	 */
	Integer insertAccount(Account account);
	/**
	 * 根据身份证查询帐务帐号
	 */
	Account selectAccountByIdcardNo(@Param("idcard_no") String idcard_no);
}
