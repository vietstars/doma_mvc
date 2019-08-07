package pwater.service;

import org.seasar.doma.jdbc.tx.TransactionManager;
import org.springframework.stereotype.Service;

import java.util.List;

import pwater.dao.AccountDaoImpl;
import pwater.config.DomaConfig;
import pwater.dao.AccountDao;
import pwater.model.Account;

@Service
@SuppressWarnings("unchecked")// warning uses unchecked or unsafe operations.
public class AccountService {

	private final AccountDao accountDao = new AccountDaoImpl();
	
    private TransactionManager tm = DomaConfig.singleton().getTransactionManager();

	public List<Account> selectAll() {
		List<Account> accounts = tm.required(() -> {			
			List<Account> list = accountDao.selectAll();
			return list;
		});
		return accounts;
	}

	public Account findByEmail(String email) {
		Account account = tm.required(() -> {			
		 	Account findout = accountDao.findByEmail(email);
		 	return findout;
		});
		return account;
	}

	public Integer newAccount(Account account) {
		Integer result = tm.required(() -> {			
		 	return accountDao.newAccount(account);
		});
		return result;
	}

	public Account findOne(Integer id) {
		Account account = tm.required(() -> {			
		 	return accountDao.findOne(id);
		});
		return account;
	}

	public Integer delAccount(Integer id) {
		Integer account = tm.required(() -> {			
		 	return accountDao.delAccount(id);
		});
		return account;
	}

}
