package pwater.entity;

import org.seasar.doma.jdbc.tx.TransactionManager;
import pwater.model.Account;
import pwater.dao.AccountDao;
import pwater.dao.AccountDaoImpl;
import pwater.config.DomaConfig;

import java.util.List;

public class AccountEntity {
	
	public List<Account> selectAll() {

		TransactionManager tm = DomaConfig.singleton().getTransactionManager();
        List accounts = tm.required(() -> {
            AccountDao dao = new AccountDaoImpl();
            List<Account> list = dao.selectAll();
            return list;
        });

        return accounts;
    }
   
}
