package com.example.lsi.entities;




import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Immobilier")
public class Immobilier {

    @Id
    private String id;

    private String owner;

    private double price;

    private String title;

    private String Ville;

    private String image;

    private Type type;

    private boolean forSell = false ;

    private boolean proved = false ;

}
