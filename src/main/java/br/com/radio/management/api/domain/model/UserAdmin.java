package br.com.radio.management.api.domain.model;

import java.util.Collection;
import java.util.Date;
// import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class UserAdmin implements UserDetails {
    // com a utilizacao de userdetails nao tem como testar o cadastro e atualização de um usuário
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long id;

    private String nameUser;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordUser;

    @Column(nullable = false)
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
    
    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(String dateRegister) {
        this.dateRegister = dateRegister;
    }

    public String getDateInativation() {
        return dateInativation;
    }

    public void setDateInativation(String dateInativation) {
        this.dateInativation = dateInativation;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return passwordUser;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


   
}
