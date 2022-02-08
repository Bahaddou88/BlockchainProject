package com.example.lsi.repository;

import com.example.lsi.entities.Immobilier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImmobilierRepository extends MongoRepository<Immobilier, String> {
    List<Immobilier> findAllById(String id);

    @Query("{ 'IsValidate' : false }")
    List<Immobilier> findNotValidateAnnounces();

    @Query("{ 'validation' : true }")
    List<Immobilier> findTrueValidateAnnounces();

    @Query("{ 'title' : ?0 }")
    Optional<Immobilier> findByHouseTitle(String houseTitle);

    @Query("{ 'validation' : true,'toPublish':false }")
    List<Immobilier> findTrueValidateAnnouncesToPublish();

    @Query("{ 'validation' : true,'toPublish':true }")
    List<Immobilier> findTrueValidateAnnouncesPublished();

    @Query("{ 'toPublish':false }")
    List<Immobilier> findAnnouncesNotPublishedYet();
}
