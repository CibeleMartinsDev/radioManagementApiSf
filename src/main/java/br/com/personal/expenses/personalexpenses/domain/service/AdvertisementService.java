package br.com.personal.expenses.personalexpenses.domain.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.personal.expenses.personalexpenses.domain.exception.ResourceNotFoundException;
import br.com.personal.expenses.personalexpenses.domain.model.Advertisement;
import br.com.personal.expenses.personalexpenses.domain.model.UserAdmin;
import br.com.personal.expenses.personalexpenses.domain.repository.AdvertisementRepository;
import br.com.personal.expenses.personalexpenses.dto.Advertisement.AdvertisementRequestDTO;
import br.com.personal.expenses.personalexpenses.dto.Advertisement.AdvertisementResponseDTO;

@Service
public class AdvertisementService implements CRUDService<AdvertisementRequestDTO, AdvertisementResponseDTO> {

    @Autowired
    private AdvertisementRepository AdvertisementRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<AdvertisementResponseDTO> getAll() {

        UserAdmin user = (UserAdmin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Advertisement> Advertisements = AdvertisementRepository.findAll();

        List<AdvertisementResponseDTO> AdvertisementsResponse = Advertisements.stream().map(t -> mapper.map(t, AdvertisementResponseDTO.class)).collect(Collectors.toList());

        return AdvertisementsResponse;
    }

    @Override
    public AdvertisementResponseDTO getById(Long id) {
        Optional<Advertisement> Advertisements = AdvertisementRepository.findById(id);

        UserAdmin user = (UserAdmin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(Advertisements.isEmpty()) {
            throw new ResourceNotFoundException("Propaganda não encontrada.");
        }

        return mapper.map(Advertisements.get(), AdvertisementResponseDTO.class);
    }

    @Override
    public AdvertisementResponseDTO register(AdvertisementRequestDTO dto) {

        Advertisement AdvertisementModel = mapper.map(dto, Advertisement.class);

        // quem é o usuário que faz essa requisição
        UserAdmin user = (UserAdmin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    
        AdvertisementModel.setId(null);
        AdvertisementModel.setDateRegister(new Date());

        AdvertisementModel = AdvertisementRepository.save(AdvertisementModel);
     
        return mapper.map(AdvertisementModel, AdvertisementResponseDTO.class);
    }

    @Override
    public AdvertisementResponseDTO updateById(Long id, AdvertisementRequestDTO dto) {
        getById(id);
        Advertisement AdvertisementModel = mapper.map(dto, Advertisement.class);

        UserAdmin user = (UserAdmin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        AdvertisementModel.setId(id);
        AdvertisementModel = AdvertisementRepository.save(AdvertisementModel);
      
        return mapper.map(AdvertisementModel, AdvertisementResponseDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        AdvertisementRepository.deleteById(id);
    }
    

 
}
