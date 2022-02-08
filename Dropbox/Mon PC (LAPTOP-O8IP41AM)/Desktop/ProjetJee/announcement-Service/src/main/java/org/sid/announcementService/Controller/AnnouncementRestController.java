package org.sid.announcementService.Controller;

import org.sid.announcementService.Repository.HouseRepository;
import org.sid.announcementService.ServiceImp.ImmobilierImp;
import org.sid.announcementService.entities.Immobilier;
import org.sid.announcementService.feign.userFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("Announce")
public class AnnouncementRestController {

    @Autowired
    public ImmobilierImp houseServiceImp;

    @Autowired
    public HouseRepository houseRepository;

    @Autowired
    public userFeign userFeign;

    @PostMapping(path = "/AddAnnounce")
    public void AddAnnounce(@RequestBody Immobilier Immobilier) {
        System.out.println(Immobilier.getNum());
        houseServiceImp.AddHouse(Immobilier);

    }

    @GetMapping("/Announce")
    public List<Immobilier> getAllAnnounces() {

        return (List<Immobilier>) houseServiceImp.getAllHouses();
    }

    @GetMapping("/AnnouncesTrueValidate")
    public List<Immobilier> getTrueValidateAnnounces() {
        return (List<Immobilier>) houseServiceImp.getTrueValidateAnnounces();
    }

    @PostMapping("/getAnnouncByOwner")
    public List<Immobilier> getAnnouncByOwner(@RequestParam(value="owner") String owner) {
        return (List<Immobilier>) houseServiceImp.findByImmobilierOwner(owner);
    }

//    @GetMapping("/AnnouncesTrueValidateToPublish")
//    public List<Immobilier> getTrueValidateAnnouncesToPublish() {
//        return (List<Immobilier>) houseServiceImp.getTrueValidateAnnouncesToPublish();
//    }
//
//    @GetMapping("/AnnouncesTrueValidatePublished")
//    public List<Immobilier> getTrueValidateAnnouncesPublished() {
//        return (List<Immobilier>) houseServiceImp.getTrueValidateAnnouncesPublished();
//    }

//    @GetMapping("/AnnouncesNotPublishedYet")
//    public List<Immobilier> getAnnouncesNotPublishedYet() {
//        return (List<Immobilier>) houseServiceImp.getAnnouncesNotPublishedYet();
//    }

    @GetMapping("/AnnouncesNotValidate")
    public List<Immobilier> getNotValidateAnnounces() {
        return (List<Immobilier>) houseServiceImp.getNotValidateAnnounces();
    }


    @GetMapping("/Announce/{id}")
    public ResponseEntity<Immobilier> getHouseById(@PathVariable(value = "id") String AnnounceId)
            throws ResourceNotFoundException {
        Immobilier Immobilier = houseServiceImp.findById(AnnounceId)
                .orElseThrow(() -> new ResourceNotFoundException("Announce not found for this id :: " + AnnounceId));
        return ResponseEntity.ok().body(Immobilier);
    }

    @PutMapping("/Announce/{id}")
    public ResponseEntity<Immobilier> updateAnnounce(@PathVariable(value = "id") String AnnounceId,
                                                     @Valid @RequestBody Immobilier HouseDetails)
            throws ResourceNotFoundException {
        Immobilier house = houseServiceImp.findById(AnnounceId)
                .orElseThrow(() -> new ResourceNotFoundException("Announce not found for this id :: " + AnnounceId));

        house.setPrice(HouseDetails.getPrice());
        house.setImage(HouseDetails.getImage());
        house.setOwner(HouseDetails.getOwner());
        final Immobilier updatedAnnounce = houseServiceImp.AddHouse(house);
        return ResponseEntity.ok(updatedAnnounce);
    }

    @DeleteMapping("/Announce/{id}")
    public Map<String, Boolean> deleteCategory(@PathVariable(value = "id") String categoryId)
            throws ResourceNotFoundException {
        Immobilier category = houseServiceImp.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + categoryId));

        houseServiceImp.delete(category);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/validate/{title}")
    public Immobilier validateAnnounce(@PathVariable(value = "title") String HouseTitle)
    {
        System.out.println("kkkkkkkkkkkkkkk" + HouseTitle);
        Immobilier immobilier=new Immobilier();
        List<Immobilier> listImmobilier=houseRepository.findAll();
        for(int i=0;i<listImmobilier.size();i++) {
            if (listImmobilier.get(i).getTitle().equals(HouseTitle)) {
                immobilier = listImmobilier.get(i);
            }
        }
         //immobilier = houseServiceImp.findByImmobilierTitle(HouseTitle);
         System.out.println("llllllllllllllll" + immobilier.getOwner());

        Immobilier immobilier1 = immobilier;
        immobilier1.setValidation(true);
        final Immobilier validatedAnnounce = houseRepository.save(immobilier1);
        houseRepository.delete(immobilier);
        System.out.println("mmmmmmmmmmmmmmmmmmmm" + immobilier.getOwner());

        return new Immobilier();

    }

//    @PutMapping("/rejectAnnounce/{title}")
//    public ResponseEntity<Immobilier> rejectAnnounce(@PathVariable(value = "title") String HouseTitle)
//            throws ResourceNotFoundException {
//        System.out.println("$$$$$$$$$$$$$$$$$$$" + HouseTitle);
//
//        Immobilier Immobilier = houseServiceImp.findByImmobilierTitle(HouseTitle)
//                .orElseThrow(() -> new ResourceNotFoundException("Announce not found for this id :: " + HouseTitle));
//
//        Immobilier.setValidation(false);
//        // Immobilier.setIsValidate(true);
//       // Immobilier.setRejected(true);
//
//        final Immobilier validatedAnnounce = houseServiceImp.AddHouse(Immobilier);
//        return ResponseEntity.ok(validatedAnnounce);
//
//    }
//
//    @PutMapping("/AddToPublication/{title}")
//    public ResponseEntity<Immobilier> AddToPublication(@PathVariable(value = "title") String HouseTitle)
//            throws ResourceNotFoundException {
//        System.out.println("$$$$$$$$$$$$$$$$$$$" + HouseTitle);
//
//        Immobilier Immobilier = houseServiceImp.findByImmobilierTitle(HouseTitle)
//                .orElseThrow(() -> new ResourceNotFoundException("Announce not found for this id :: " + HouseTitle));
//
//        Immobilier.setToPublish(true);
//
//        final Immobilier validatedAnnounce = houseServiceImp.AddHouse(Immobilier);
//        return ResponseEntity.ok(validatedAnnounce);
//
//    }
//
//    @PutMapping("/RemoveFromPublication/{title}")
//    public ResponseEntity<Immobilier> RemoveFromPublication(@PathVariable(value = "title") String HouseTitle)
//            throws ResourceNotFoundException {
//        System.out.println("$$$$$$$$$$$$$$$$$$$" + HouseTitle);
//
//        Immobilier Immobilier = houseServiceImp.findByImmobilierTitle(HouseTitle)
//                .orElseThrow(() -> new ResourceNotFoundException("Announce not found for this id :: " + HouseTitle));
//
//        Immobilier.setToPublish(false);
//
//        final Immobilier validatedAnnounce = houseServiceImp.AddHouse(Immobilier);
//        return ResponseEntity.ok(validatedAnnounce);
//
//    }

//
//    @GetMapping("/GetUserById")
//    public String GetUserById(HttpServletRequest request) {
//        String id = userFeign.getUserId(request.getHeader("Authorization"));
//        return id;
//    }
//
//    @GetMapping("/consulterById")
//    public List<Immobilier> showPropertyListByUserId(HttpServletRequest request) {
//        String id = userFeign.getUserId(request.getHeader("Authorization"));
//        return houseRepository.findAllById(id);

}

