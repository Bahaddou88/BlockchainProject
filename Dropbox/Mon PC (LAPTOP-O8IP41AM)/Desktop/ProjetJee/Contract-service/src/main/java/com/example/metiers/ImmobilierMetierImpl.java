package com.example.metiers;

import com.example.Dtos.TransferImmobilier;
import com.example.models.Immobilier;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ChainId;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;
import wrapper.MyImmobilierContract;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class ImmobilierMetierImpl implements ImmobilierMetier {

    private static final BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    private static final BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    private final static String PRIVATE_KEY = "7a03e40576abc3dec2016d839cab663cda1f50572ad4e7fe7861502c3ea9c48d";
    private final static String CONTRACT_ADDRESS = "0x0A4A08184c007988482fA947DA00dC602224A10D";

    Web3j web3 = Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));
    Credentials credentials = Credentials.create(PRIVATE_KEY);
    TransactionManager transactionManager = new RawTransactionManager(
            web3, credentials, ChainId.MAINNET);

    @Override
    public void DeployContract() throws Exception {
        MyImmobilierContract contract = MyImmobilierContract.deploy(web3, credentials, GAS_PRICE, GAS_LIMIT).send();
        System.out.println("Contract is Deployed");
    }

    @Override
    public void AddImmobilier(Immobilier addImmobilier) throws Exception {
        //  Credentials credentials2 = Credentials.create(addImmobilier.getPrivat_key());
        System.out.println(addImmobilier.getOwner());
        MyImmobilierContract loadAddress = MyImmobilierContract.load(CONTRACT_ADDRESS, web3, credentials, GAS_PRICE, GAS_LIMIT);
        System.out.println("Deployed contract address :" + loadAddress.getContractAddress());

        loadAddress.addImmobilier(addImmobilier.getOwner(), addImmobilier.getTitre(), addImmobilier.getPrice()).send();
        System.out.println(addImmobilier.getOwner());
    }

    @Override
    public String transferImmobilier(TransferImmobilier transferImmobilier) {
        MyImmobilierContract loadAddress = MyImmobilierContract.load(CONTRACT_ADDRESS, web3, transactionManager, GAS_PRICE, GAS_LIMIT);
        loadAddress.transferImmobilier(transferImmobilier.getBuyer(), transferImmobilier.getOwner(), transferImmobilier.getId());
        System.out.println("transfer immobilier");
        return "Done";
    }

    @Override
    public BigInteger numberOfImmobilier() throws Exception {
        MyImmobilierContract contract = MyImmobilierContract.load(CONTRACT_ADDRESS, web3, transactionManager, GAS_PRICE, GAS_LIMIT);
        return contract.totalImmobilier().send();
    }

    @Override
    public RemoteFunctionCall<List> getImmobiliersFromeHolder(String holder) throws Exception {
        MyImmobilierContract contract = MyImmobilierContract.load(CONTRACT_ADDRESS, web3, transactionManager, GAS_PRICE, GAS_LIMIT);
        contract.getImmobilierFromHolder(holder);
        return contract.getImmobilierFromHolder(holder);
    }

    @Override
    public void transferEther(TransferImmobilier transferEther) throws Exception {
        Credentials credentials2 = Credentials.create(transferEther.getPrivate_key_buyer());
        TransactionReceipt transactionReceipt = Transfer.sendFunds(
                web3, credentials2, transferEther.getOwner(),
                BigDecimal.valueOf(transferEther.getPrice()), Convert.Unit.ETHER).send();
        System.out.println("transaction : " + transactionReceipt);
    }
}
