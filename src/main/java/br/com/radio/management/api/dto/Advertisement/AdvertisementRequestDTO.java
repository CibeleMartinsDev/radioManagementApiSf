package br.com.radio.management.api.dto.Advertisement;


import java.util.Date;
import java.util.List;

import br.com.radio.management.api.domain.model.Customer;


public class AdvertisementRequestDTO {

   
    private Long id;

    private String name;

    private String customer;

    private String frenquencyDivulgation;

    private List<String> advertisingSchedules;

    private String amount;

    private Double datePayement;

    private Boolean active;

    private String dateRegister;
    
    private String observation;

    private String dateActivation;

    private String dateDeactivation;

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
    public String getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(String customer) {
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
    public List<String> getAdvertisingSchedules() {
        return advertisingSchedules;
    }

    /**
     * @param advertisingSchedules the advertisingSchedules to set
     */
    public void setAdvertisingSchedules(List<String> advertisingSchedules) {
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
    public String getDateRegister() {
        return dateRegister;
    }

    /**
     * @param dateRegister the dateRegister to set
     */
    public void setDateRegister(String dateRegister) {
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
    public String getDateActivation() {
        return dateActivation;
    }

    /**
     * @param dateActivation the dateActivation to set
     */
    public void setDateActivation(String dateActivation) {
        this.dateActivation = dateActivation;
    }

    /**
     * @return Date return the dateDeactivation
     */
    public String getDateDeactivation() {
        return dateDeactivation;
    }

    /**
     * @param dateDeactivation the dateDeactivation to set
     */
    public void setDateDeactivation(String dateDeactivation) {
        this.dateDeactivation = dateDeactivation;
    }

}
