package org.sid.announcementService.ServiceImp;

import org.sid.announcementService.Repository.HouseRepository;
import org.sid.announcementService.ServiceDao.ImmobilierMetier;
import org.sid.announcementService.entities.Immobilier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ImmobilierImp implements ImmobilierMetier {

    @Autowired
    public HouseRepository houseRepository;

    @Override
    public Immobilier AddHouse(Immobilier Immobilier) {

        return houseRepository.save(Immobilier);
    }

    public List<Immobilier> getAllHouses() {

        return houseRepository.findAll();
    }

    public Optional<Immobilier> findById(String houseId) {

        return houseRepository.findById(houseId);
    }

    @Override
    public void delete(Immobilier Immobilier) {
        houseRepository.delete(Immobilier);
    }


    @Override
    public List<Immobilier> getNotValidateAnnounces() {

        return houseRepository.findNotValidateAnnounces();
    }

    @Override
    public List<Immobilier> getTrueValidateAnnounces() {
        return houseRepository.findTrueValidateAnnounces();
    }

    @Override
    public Immobilier findByImmobilierTitle(String houseTitle) {
        return houseRepository.findByImmobilierTitle(houseTitle);
    }

    @Override
    public List<Immobilier>  findByImmobilierOwner(String owner) {
        return (List<Immobilier>) houseRepository.findByImmobilierOwner(owner);
    }

//    @Override
//    public List<Immobilier> getTrueValidateAnnouncesToPublish() {
//        return houseRepository.findTrueValidateAnnouncesToPublish();
//    }
//
//    @Override
//    public List<Immobilier> getTrueValidateAnnouncesPublished() {
//        return houseRepository.findTrueValidateAnnouncesPublished();
//    }
//    @Override
//    public List<Immobilier> getAnnouncesNotPublishedYet() {
//        return houseRepository.findAnnouncesNotPublishedYet();
//    }

}
