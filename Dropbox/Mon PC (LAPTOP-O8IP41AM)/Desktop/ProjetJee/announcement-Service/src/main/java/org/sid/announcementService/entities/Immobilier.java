package org.sid.announcementService.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "Immobilier2")
public class Immobilier {
    @Id
    private String id;
    private String owner;
    private String title;
    private Double price;
    private String image;
    private boolean validation;
    private boolean isValidate;
    private  boolean toPublish;
    private  boolean isRejected;
    private  int num=0;

}
