package com.example.lsi.controller;


import com.example.lsi.entities.Immobilier;
import com.example.lsi.metier.ImmobilierMetierImmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/announces")
public class ImmobilierController {

    @Autowired
    ImmobilierMetierImmp immobilierMetierImmp ;

   @GetMapping("/immobiliers")
    public List<Immobilier> getAllImmobiliers(){
        return immobilierMetierImmp.getAllImmobiliers();
    }

    @GetMapping("/immobiliersid/{id}")
    public Optional<Immobilier> getAllImmobilierById(@PathVariable("id") String id){
        return immobilierMetierImmp.getImmobilierById(id);
    }

   @PostMapping("/AddImmobiliers")
    public void AddImmobiliesr(@RequestBody Immobilier immobilier){

       System.out.println("called************************************************");
       immobilierMetierImmp.saveImmobilier(immobilier);
    }
    @GetMapping("/AnnouncesTrueValidate")
    public List<Immobilier> getTrueValidateAnnounces() {
        return (List<Immobilier>) immobilierMetierImmp.getTrueValidateAnnounces();
    }
    @GetMapping("/AnnouncesNotValidate")
    public List<Immobilier> getNotValidateAnnounces() {
        return (List<Immobilier>) immobilierMetierImmp.getNotValidateAnnounces();
    }

}
