package pwater.model;

import java.util.List;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import org.seasar.doma.Column;

import lombok.Data;
 

import pwater.service.AccountService;

@Data //support getter setter
@Entity
@Table(name="account")
public class Account {

	@Column(name = "id")
	private Long id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "gender")
	private String gender;

	// public Long getId() {
	// 	return id;
	// }

	// public void setId(Long id) {
	// 	this.id = id;
	// }

	// public String getEmail() {
	// 	return email;
	// }

	// public void setName(String email) {
	// 	this.email = email;
	// }

	// public String getPasword() {
	// 	return password;
	// }

	// public void setPasword(String password) {
	// 	this.password = password;
	// }

	// public String getGender() {
	// 	return gender;
	// }

	// public void setGender(String gender) {
	// 	this.gender = gender;
	// }

	public List selectAll() {
		AccountService accountService = new AccountService();
		List<Account> accounts = accountService.selectAll();
		return accounts;
	}

	 public Account findByEmail(String email) {
	 	AccountService accountService = new AccountService();
	 	Account account = accountService.findByEmail(email);
	 	return account;
	 }
}