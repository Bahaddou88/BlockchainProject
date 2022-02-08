package com.example.Dtos;

import lombok.Data;

import java.math.BigInteger;

@Data
public class TransferImmobilier {

    private String private_key_buyer;
    private String buyer;
    private String owner;
    private long price;
    private BigInteger id;

}
