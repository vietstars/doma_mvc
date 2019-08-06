package pwater.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.experimental.Sql;

import pwater.config.DomaConfig;
import pwater.model.Account;

@Dao(config = DomaConfig.class)
public interface AccountDao {

	// @Sql("SELECT account.id as id,account.email as email,account.gender as gender FROM account")
	@Select
	List<Account> selectAll();


	@Select
	@Sql("SELECT account.id as id,account.email as email,account.password as password,account.gender as gender FROM account WHERE account.email= /* email */'a'")
	Account findByEmail(String email);


}