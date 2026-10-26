package org.example.model;

public class SignupRequest {

    private final String email;
    private final String password;
    private final String submitPassword;

    public SignupRequest(String email, String password) {
        this.email = email;
        this.password = password;
        this.submitPassword = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSubmitPassword() {
        return submitPassword;
    }
}