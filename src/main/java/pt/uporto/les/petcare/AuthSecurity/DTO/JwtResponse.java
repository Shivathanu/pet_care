package pt.uporto.les.petcare.AuthSecurity.DTO;

import java.io.Serializable;

public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private final Long id;

    public JwtResponse(String jwttoken, Long id) {
        this.jwttoken = jwttoken;
        this.id = id;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public Long getId() {
        return id;
    }
}