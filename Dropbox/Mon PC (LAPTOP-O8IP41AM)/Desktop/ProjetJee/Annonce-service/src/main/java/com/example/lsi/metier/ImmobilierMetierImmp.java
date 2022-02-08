package com.example.lsi.metier;

import com.example.lsi.entities.Immobilier;
import com.example.lsi.repository.ImmobilierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImmobilierMetierImmp implements ImmobilierMetier{

    @Autowired
    ImmobilierRepository immobilierRepository;

    @Override
    public Immobilier saveImmobilier(Immobilier immobilier) {
        return immobilierRepository.save(immobilier);
    }

    @Override
    public List<Immobilier> getAllImmobiliers() {
        return immobilierRepository.findAll();
    }

    @Override
    public Optional<Immobilier> getImmobilierById(String id) {
        return immobilierRepository.findById(id);
    }

    @Override
    public List<Immobilier> getNotValidateAnnounces() {
        return immobilierRepository.findNotValidateAnnounces();
    }

    @Override
    public List<Immobilier> getTrueValidateAnnounces() {
        return immobilierRepository.findTrueValidateAnnounces();
    }

    @Override
    public Optional<Immobilier> findByHouseTitle(String houseTitle) {
        return immobilierRepository.findByHouseTitle(houseTitle);
    }

}
