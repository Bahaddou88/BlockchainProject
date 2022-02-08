package com.example.metiers;

import com.example.Dtos.TransferImmobilier;
import com.example.models.Immobilier;
import org.web3j.protocol.core.RemoteFunctionCall;

import java.math.BigInteger;
import java.util.List;

public interface ImmobilierMetier {

    public void DeployContract() throws Exception;

    public void AddImmobilier(Immobilier Immobilier) throws Exception;

    public String transferImmobilier(TransferImmobilier transferImmobilier);

    public BigInteger numberOfImmobilier() throws Exception;

    public RemoteFunctionCall<List> getImmobiliersFromeHolder(String holder) throws Exception;

    public void transferEther(TransferImmobilier transferEther) throws Exception;

}
