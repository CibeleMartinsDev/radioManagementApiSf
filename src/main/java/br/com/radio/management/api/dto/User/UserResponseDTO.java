package br.com.radio.management.api.dto.User;


public class UserResponseDTO {

    private Long id;

    private String nameUser;

    private String email;

    private String dateRegister;

    private String dateInativation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateInativation() {
        return dateInativation;
    }

    public void setDateInativation(String dateInativation) {
        this.dateInativation = dateInativation;
    }
    
    public String getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(String dateRegister) {
        this.dateRegister = dateRegister;
    }

}
