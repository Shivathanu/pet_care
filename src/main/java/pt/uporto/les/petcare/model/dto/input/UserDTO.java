package pt.uporto.les.petcare.model.dto.input;

import pt.uporto.les.petcare.model.user.User;

public class UserDTO {

    private String username;
    private String password;
    private String email;
    private String name;
    private String mobile;

    public UserDTO(String username, String password, String email, String name, String mobile) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.mobile = mobile;
    }

    public UserDTO() {
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public User toObject() {

        return new User(this.email, this.name, this.mobile, this.password, null);
    }
}
