package com.ocem.getwheels.Modelresponse;

public class RegisterResponse {


    String success;
    User user;
    String token;
    String message;

    public RegisterResponse(String success, User user, String token, String message) {
        this.success = success;
        this.user = user;
        this.token = token;
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RegisterResponse{" +
                "success='" + success + '\'' +
                ", user=" + user +
                ", token='" + token + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
