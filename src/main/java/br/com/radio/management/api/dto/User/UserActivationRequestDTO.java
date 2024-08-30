package br.com.radio.management.api.dto.User;

public class UserActivationRequestDTO {
    
    private String email;

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
