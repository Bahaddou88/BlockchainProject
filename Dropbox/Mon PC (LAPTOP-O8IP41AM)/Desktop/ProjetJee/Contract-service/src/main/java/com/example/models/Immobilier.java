package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.web3j.abi.datatypes.Type;

import java.math.BigInteger;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Immobilier implements Type {

    private String owner;
    private String titre;
    private BigInteger price;

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public String getTypeAsString() {
        return null;
    }
}

