package pwater.service;

import org.seasar.doma.jdbc.tx.TransactionManager;
import org.springframework.stereotype.Service;

import java.util.List;

import pwater.dao.JobDaoImpl;
import pwater.config.DomaConfig;
import pwater.dao.JobDao;
import pwater.model.Job;

// @SuppressWarnings("unchecked")// warning uses unchecked or unsafe operations.
@Service
public class JobService {

	private final JobDao jobDao = new JobDaoImpl();
	
    private TransactionManager tm = DomaConfig.singleton().getTransactionManager();

	public List<Job> selectAll() {
		List<Job> jobs = tm.required(() -> {			
			List<Job> list = jobDao.selectAll();
			return list;
		});
		return jobs;
	}

	// public Account findByEmail(String email) {
	// 	Account account = tm.required(() -> {			
	// 	 	Account findout = accountDao.findByEmail(email);
	// 	 	return findout;
	// 	});
	// 	return account;
	// }

	// public boolean newAccount(Account account) {
	// 	boolean created = false;
	// 	try{
	// 		created = tm.required(() -> {			
	// 		 	int result = accountDao.newAccount(account);
	// 		 	return result == 1;
	// 		});
	// 	}catch(Exception e){
	//       	System.out.println("INSERT FAILS: "+ account.getEmail());
	//   	}finally {
	// 		return created;
	//     }
	// }

	// public Account findOne(Integer id) {
	// 	Account account = tm.required(() -> {			
	// 	 	return accountDao.findOne(id);
	// 	});
	// 	return account;
	// }

	// public void toggleBan(Integer id) {
	// 	tm.required(() -> {	
	// 		Account account = accountDao.findOne(id);
	// 		account.setStatus(account.getStatus()==1?0:1);
	// 		System.out.println("---------------");		
	// 		System.out.println(account);		
	// 		System.out.println("---------------");		
	// 	 	accountDao.toggleBan(account);
	// 	});
	// }

	// public boolean delAccount(Integer id) {
	// 	boolean deleted = false;
	// 	deleted = tm.required(() -> {			
	// 	 	int result = accountDao.delAccount(id);
	// 	 	return result == 1;
	// 	});
	// 	return deleted;
	// }

}
