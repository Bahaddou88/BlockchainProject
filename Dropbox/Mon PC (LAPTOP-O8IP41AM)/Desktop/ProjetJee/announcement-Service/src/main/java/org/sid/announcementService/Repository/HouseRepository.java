package org.sid.announcementService.Repository;

import org.sid.announcementService.entities.Immobilier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends MongoRepository<Immobilier, String> {

    List<Immobilier> findAllById(String id);

    @Query("{ 'IsValidate' : false }")
    List<Immobilier> findNotValidateAnnounces();

    @Query("{ 'validation' : true }")
    List<Immobilier> findTrueValidateAnnounces();

    @Query("{ 'title' : ?0 }")
    public Immobilier findByImmobilierTitle(String Title);

    @Query("{ 'owner' : ?0 }")
    public List<Immobilier> findByImmobilierOwner(String owner);

//    @Query("{ 'validation' : true,'toPublish':false }")
//    List<Immobilier> findTrueValidateAnnouncesToPublish();
//
//    @Query("{ 'validation' : true,'toPublish':true }")
//    List<Immobilier> findTrueValidateAnnouncesPublished();
//
//    @Query("{ 'toPublish':false }")
//    List<Immobilier> findAnnouncesNotPublishedYet();
}


