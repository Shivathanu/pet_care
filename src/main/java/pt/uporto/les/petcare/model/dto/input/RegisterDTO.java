package pt.uporto.les.petcare.model.dto.input;

import pt.uporto.les.petcare.model.user.User;

public class RegisterDTO {

    private UserDTO userToRegister;
    private String role;

    public RegisterDTO(UserDTO userToRegister, String role) {
        this.userToRegister = userToRegister;
        this.role = role;
    }

    public RegisterDTO(RegisterDTO dto) {
        this.userToRegister = dto.userToRegister;
        this.role = dto.role;
    }

    public RegisterDTO() {

    }

    public UserDTO getUserToRegister() {
        return userToRegister;
    }

    public void setUserToRegister(UserDTO userToRegister) {
        this.userToRegister = userToRegister;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RegisterDTO{");
        sb.append("userToRegister=").append(userToRegister);
        sb.append(", role='").append(role).append('\'');
        sb.append('}');
        return sb.toString();
    }



    public User toObject() {

        return new User(userToRegister.toObject());
    }
}
