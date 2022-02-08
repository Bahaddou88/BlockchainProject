package com.example.Dtos;

import lombok.Data;

@Data
public class TransferEther {

    private String private_key;
    private String buyer;
    private long price;
}
