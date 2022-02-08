package com.example.Dtos;


import lombok.Data;

import java.math.BigInteger;

@Data
public class AddImmobilier {

    private String owner;
    private String title;
    private BigInteger price;
    private String image;

}
