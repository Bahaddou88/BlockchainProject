package com.example.controller;


import com.example.Dtos.AddImmobilier;
import com.example.Dtos.TransferImmobilier;
import com.example.metiers.ImmobilierMetierImpl;
import com.example.models.Immobilier;
import io.reactivex.Flowable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ChainId;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;
import java.util.List;

@RequestMapping("contracts")
@RestController
public class ImmobilierController {

    private static final BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    private static final BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    private final static String PRIVATE_KEY = "7a03e40576abc3dec2016d839cab663cda1f50572ad4e7fe7861502c3ea9c48d";
    private final static String CONTRACT_ADDRESS = "0x0A4A08184c007988482fA947DA00dC602224A10D";

    Web3j web3 = Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));
    Credentials credentials = Credentials.create(PRIVATE_KEY);
    TransactionManager transactionManager = new RawTransactionManager(
            web3, credentials, ChainId.MAINNET);


    @Autowired
    private ImmobilierMetierImpl immobilierMetierImpl;

    @GetMapping("/hello")
    public String SayHelloToMe() {
        return "hello to me";
    }

    @GetMapping("/numberOfImmobilier")
    public BigInteger numberOfImmobilier() throws Exception {
        return immobilierMetierImpl.numberOfImmobilier();
    }

    @GetMapping("/DeployContract")
    public void DeployContract() throws Exception {
        immobilierMetierImpl.DeployContract();
    }

    @PostMapping(path = "/AddImmobilier")
    public void AddImmobilier(@RequestBody AddImmobilier immobilier) throws Exception {
        System.out.println("dddddddddddddddddddddddd");
        Immobilier immobilier1 = new Immobilier();
        immobilier1.setPrice(immobilier.getPrice());
        immobilier1.setTitre(immobilier.getTitle());
        immobilier1.setOwner(immobilier.getOwner());
        System.out.println("owner " + immobilier.getOwner());
        immobilierMetierImpl.AddImmobilier(immobilier1);
    }

    @PostMapping(path = "/TransferImmobilier")
    public void transferImmobilier(@RequestBody TransferImmobilier transferImmobilier) throws Exception {
        immobilierMetierImpl.transferImmobilier(transferImmobilier);
        //immobilierMetierImpl.transferEther(transferImmobilier);
        System.out.println("transfer ether");
    }

    @PostMapping(path = "/TransferEther")
    public void transferEther(@RequestBody TransferImmobilier transferEther) throws Exception {
        System.out.println("begin ethe transfer ");
        immobilierMetierImpl.transferEther(transferEther);
        System.out.println("transfer ethe");
    }

    @GetMapping("allImmobiliersFromeHolder")
    public List<Immobilier> getAllImmobiliers(String holder) throws Exception {
        return (List<Immobilier>) immobilierMetierImpl.getImmobiliersFromeHolder(holder);
    }

    @GetMapping("/transactions")
    public Flowable<Transaction> getTransactions() throws Exception {
        System.out.println("call transactions");
        BigInteger block = web3.ethBlockNumber().send().getBlockNumber();
        System.out.println("blockno:" + block.intValue());
        Flowable<org.web3j.protocol.core.methods.response.Transaction> transactions = web3.replayPastTransactionsFlowable(DefaultBlockParameterName.EARLIEST,
                DefaultBlockParameterName.LATEST).serialize();
        System.out.println();
        return transactions;
    }

//    @GetMapping("/test")
//    public List<Transaction> test() throws InterruptedException, ExecutionException, IOException {
//        String address = "0xeedc155ae507fb0a9becae6315286183a23229b0";
//        List<Transaction> transactions = new ArrayList<Transaction>();
//        Web3j web3j = web3jConfig.initializeWeb3j();
//        System.out.println("test Running.......");
//        BigInteger block = web3j.ethBlockNumber().send().getBlockNumber();
//        System.out.println("blockno:" + block.intValue());
//        int block_no = block.intValue();
//
//
//        Flowable<Transaction> replyBlocks = web3j.replayPastTransactionsFlowable(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST);
//        replyBlocks.forEach(temp -> {
//            System.out.println("into replyBlocks");
//            System.out.println(temp.getBlockNumber());
//            transactions.add(temp); //It's an collection object,and value is not adding into it
//        });
//
//        return transactions;
//    }

/*    @GetMapping("/test")
    public List<Transaction> test() throws InterruptedException, ExecutionException, IOException {
        String address = "0xeedc155ae507fb0a9becae6315286183a23229b0";
        List<Transaction> transactions = new ArrayList<Transaction>();
        System.out.println("test Running.......");
        BigInteger block = web3.ethBlockNumber().send().getBlockNumber();
        System.out.println("blockno:" + block.intValue());
        int block_no = block.intValue();


        Flowable<org.web3j.protocol.core.methods.response.Transaction> replyBlocks = web3.replayPastTransactionsFlowable(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST);
        replyBlocks.forEach(temp -> {
            System.out.println("into replyBlocks");
            System.out.println(temp.getBlockNumber());
            transactions.add(temp); //It's an collection object,and value is not adding into it
        });

        return transactions;
    }*/


}
