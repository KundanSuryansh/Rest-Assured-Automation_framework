package org.example.modals.request;

public class UserLogin {

    private String email;
    private String password;

    public UserLogin(){ }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
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

}
