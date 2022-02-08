package org.sid.announcementService.ServiceDao;

import org.sid.announcementService.entities.Immobilier;

import java.util.List;
import java.util.Optional;

public interface ImmobilierMetier {
    public Immobilier AddHouse(Immobilier immobilier);
    public List<Immobilier> getAllHouses();
    public Optional<Immobilier> findById(String id);

    void delete(Immobilier Immobilier);

    public List<Immobilier> getNotValidateAnnounces();

    public List<Immobilier> getTrueValidateAnnounces();

    Immobilier findByImmobilierTitle(String houseTitle);

    List<Immobilier>  findByImmobilierOwner(String owner);

//    public List<Immobilier> getTrueValidateAnnouncesToPublish();
//
//    public List<Immobilier> getTrueValidateAnnouncesPublished();
//
//    public List<Immobilier> getAnnouncesNotPublishedYet();

}

