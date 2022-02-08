package com.example.lsi.metier;

import com.example.lsi.entities.Immobilier;

import java.util.List;
import java.util.Optional;

public interface ImmobilierMetier {

     Immobilier saveImmobilier(Immobilier immobilier);

     List<Immobilier> getAllImmobiliers();

     Optional<Immobilier> getImmobilierById(String id);

     public List<Immobilier> getNotValidateAnnounces();

     public List<Immobilier> getTrueValidateAnnounces();

     Optional<Immobilier> findByHouseTitle(String houseTitle);

}
