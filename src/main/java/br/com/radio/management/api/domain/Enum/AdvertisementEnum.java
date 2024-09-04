package br.com.radio.management.api.domain.Enum;

public enum AdvertisementEnum {

    NOT_ACTIVE(false),
    ACTIVE(true);

    private Boolean active;

    AdvertisementEnum(boolean active) {

        this.active = active;
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

}
