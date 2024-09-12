package br.com.radio.management.api.dto.Customer;

import java.util.List;

import br.com.radio.management.api.domain.model.Advertisement;

public class CustomerResponseDTO extends CustomerRequestDTO {
        private List<Advertisement> advertisements;

        public List<Advertisement> getAdvertisements() {
            return advertisements;
        }

        public void setAdvertisements(List<Advertisement> advertisements) {
            this.advertisements = advertisements;
        }
}
