package pwater.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pwater.config.DomaConfig;
import pwater.model.Account;

@Dao(config = DomaConfig.class)
public interface AccountDao {
	
	@Select
	List<Account> selectAll();
	
}