package br.com.radio.management.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.radio.management.api.domain.service.AdvertisementService;
import br.com.radio.management.api.dto.Advertisement.AdvertisementRequestDTO;
import br.com.radio.management.api.dto.Advertisement.AdvertisementResponseDTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/advertisement")
public class AdvertisementController {

    @Autowired
    private AdvertisementService AdvertisementService;

    @GetMapping
    public ResponseEntity<List<AdvertisementResponseDTO>> getAll() {

        return ResponseEntity.ok(AdvertisementService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvertisementResponseDTO> getById(@PathVariable Long id) {

        return ResponseEntity.ok(AdvertisementService.getById(id));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<AdvertisementResponseDTO> getById(@PathVariable String name) {

        return ResponseEntity.ok(AdvertisementService.getByName(name));
    }

    @PostMapping
    public ResponseEntity<AdvertisementResponseDTO> register(@RequestBody AdvertisementRequestDTO Advertisement) {
        AdvertisementResponseDTO AdvertisementResponse = AdvertisementService.register(Advertisement);
        return new ResponseEntity<>(AdvertisementResponse, HttpStatus.CREATED);
    } 

    @PutMapping("/{id}")
    public ResponseEntity<AdvertisementResponseDTO> update(@PathVariable Long id ,@RequestBody AdvertisementRequestDTO Advertisement) {

        return new ResponseEntity<>(AdvertisementService.updateById(id,Advertisement), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        AdvertisementService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
