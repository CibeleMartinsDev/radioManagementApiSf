package br.com.radio.management.api.domain.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long id;

    @Column(nullable = false, name = "name_customer")
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone_number_1;

    @Column(nullable = true)
    private String phone_number_2;

    @Column(nullable = false)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return String return the phone_number_1
     */
    public String getPhone_number_1() {
        return phone_number_1;
    }

    /**
     * @param phone_number_1 the phone_number_1 to set
     */
    public void setPhone_number_1(String phone_number_1) {
        this.phone_number_1 = phone_number_1;
    }

    /**
     * @return String return the phone_number_2
     */
    public String getPhone_number_2() {
        return phone_number_2;
    }

    /**
     * @param phone_number_2 the phone_number_2 to set
     */
    public void setPhone_number_2(String phone_number_2) {
        this.phone_number_2 = phone_number_2;
    }

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
