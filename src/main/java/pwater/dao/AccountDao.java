package pwater.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.Insert;
import org.seasar.doma.Update;
import org.seasar.doma.experimental.Sql;

import pwater.config.DomaConfig;
import pwater.model.Account;

@Dao(config = DomaConfig.class)
public interface AccountDao {

	// @Sql("SELECT account.id as id,account.email as email,account.gender as gender FROM account")
	@Select
	List<Account> selectAll();

	@Sql("SELECT account.email as email,account.gender as gender FROM account WHERE account.id = /* id */'0'")
	@Select
	Account findOne(int id);

	@Select
	@Sql("SELECT account.id as id,account.email as email,account.password as password,account.gender as gender FROM account WHERE account.email = /* email */'a'")
	Account findByEmail(String email);

	@Insert
	@Sql("INSERT INTO account (id, email, password, gender) VALUES (/* account.id */0,/* account.email */'',/* account.password */100,/* account.gender */0)")
	int newAccount(Account account);

	@Update
	@Sql("UPDATE account SET status = '2' WHERE id = /* id */0")
	int delAccount(int id);

}

