package br.com.personal.expenses.personalexpenses.dto.Advertisement;


import java.util.Date;
import java.util.List;

import br.com.personal.expenses.personalexpenses.domain.model.Customer;


public class AdvertisementRequestDTO {

   
    private Long id;

    private String name;

    private Customer customer;

    private String frenquencyDivulgation;

    private List<Integer> advertisingSchedules;

    private String amount;

    private Double datePayement;

    private Boolean active;

    private Date dateRegister;
    
    private String observation;

    private Date dateActivation;

    private Date dateDeactivation;

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
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
     * @return Customer return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return String return the frenquencyDivulgation
     */
    public String getFrenquencyDivulgation() {
        return frenquencyDivulgation;
    }

    /**
     * @param frenquencyDivulgation the frenquencyDivulgation to set
     */
    public void setFrenquencyDivulgation(String frenquencyDivulgation) {
        this.frenquencyDivulgation = frenquencyDivulgation;
    }

    /**
     * @return List<Integer> return the advertisingSchedules
     */
    public List<Integer> getAdvertisingSchedules() {
        return advertisingSchedules;
    }

    /**
     * @param advertisingSchedules the advertisingSchedules to set
     */
    public void setAdvertisingSchedules(List<Integer> advertisingSchedules) {
        this.advertisingSchedules = advertisingSchedules;
    }

    /**
     * @return String return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return Double return the datePayement
     */
    public Double getDatePayement() {
        return datePayement;
    }

    /**
     * @param datePayement the datePayement to set
     */
    public void setDatePayement(Double datePayement) {
        this.datePayement = datePayement;
    }

    /**
     * @return Boolean return the active
     */
    public Boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * @return Date return the dateRegister
     */
    public Date getDateRegister() {
        return dateRegister;
    }

    /**
     * @param dateRegister the dateRegister to set
     */
    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    /**
     * @return String return the observation
     */
    public String getObservation() {
        return observation;
    }

    /**
     * @param observation the observation to set
     */
    public void setObservation(String observation) {
        this.observation = observation;
    }


    /**
     * @return Date return the dateActivation
     */
    public Date getDateActivation() {
        return dateActivation;
    }

    /**
     * @param dateActivation the dateActivation to set
     */
    public void setDateActivation(Date dateActivation) {
        this.dateActivation = dateActivation;
    }

    /**
     * @return Date return the dateDeactivation
     */
    public Date getDateDeactivation() {
        return dateDeactivation;
    }

    /**
     * @param dateDeactivation the dateDeactivation to set
     */
    public void setDateDeactivation(Date dateDeactivation) {
        this.dateDeactivation = dateDeactivation;
    }

}
