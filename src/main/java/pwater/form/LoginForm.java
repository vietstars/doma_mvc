package pwater.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {

    @NotNull(message="Must email is not null!")
    @Size(min=8, max=35, message="Please enter correctly required length of email!")
    private String email;

    @NotNull(message="Must password is not null!")
    @Size(min=6, max=20, message="Please enter correctly required length of pasword!")
    private String password;

    @Size(min=1, max=1)
    private String remember;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }

}