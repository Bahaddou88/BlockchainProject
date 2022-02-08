package C:/Users/bahad/Desktop/LSI2/blockchaine/Contract-service;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class MyImmobilierContract extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600060018190555061115c806100686000396000f3fe6080604052600436106100705760003560e01c806361192c1b1161004e57806361192c1b146101015780637dcd1a2e1461012a5780638da5cb5b14610167578063c1b8a1a51461019257610070565b806305b1137b1461007557806325cf53dc1461009157806354eefe9c146100c1575b600080fd5b61008f600480360381019061008a9190610b4e565b6101bd565b005b6100ab60048036038101906100a69190610bcc565b610208565b6040516100b89190610c3a565b60405180910390f35b3480156100cd57600080fd5b506100e860048036038101906100e39190610c55565b610609565b6040516100f89493929190610d4c565b60405180910390f35b34801561010d57600080fd5b5061012860048036038101906101239190610ecd565b6106fe565b005b34801561013657600080fd5b50610151600480360381019061014c9190610f3c565b6108cb565b60405161015e9190610f69565b60405180910390f35b34801561017357600080fd5b5061017c610917565b6040516101899190610f84565b60405180910390f35b34801561019e57600080fd5b506101a761093b565b6040516101b49190610f69565b60405180910390f35b8173ffffffffffffffffffffffffffffffffffffffff166108fc829081150290604051600060405180830381858888f19350505050158015610203573d6000803e3d6000fd5b505050565b600080600090505b600260008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020805490508110156105fc5782600260008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002082815481106102ac576102ab610f9f565b5b90600052602060002090600402016000015414156105e957600060405180608001604052808581526020018773ffffffffffffffffffffffffffffffffffffffff168152602001600260008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020848154811061034457610343610f9f565b5b9060005260206000209060040201600201805461036090610ffd565b80601f016020809104026020016040519081016040528092919081815260200182805461038c90610ffd565b80156103d95780601f106103ae576101008083540402835291602001916103d9565b820191906000526020600020905b8154815290600101906020018083116103bc57829003601f168201915b50505050508152602001600260008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020848154811061043457610433610f9f565b5b9060005260206000209060040201600301548152509050600260008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190806001815401808255809150506001900390600052602060002090600402016000909190919091506000820151816000015560208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506040820151816002019080519060200190610521929190610941565b50606082015181600301555050600260008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600061057991906109c7565b8573ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef866040516105d69190610f69565b60405180910390a3600192505050610602565b80806105f49061105e565b915050610210565b50600090505b9392505050565b6002602052816000526040600020818154811061062557600080fd5b9060005260206000209060040201600091509150508060000154908060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169080600201805461067590610ffd565b80601f01602080910402602001604051908101604052809291908181526020018280546106a190610ffd565b80156106ee5780601f106106c3576101008083540402835291602001916106ee565b820191906000526020600020905b8154815290600101906020018083116106d157829003601f168201915b5050505050908060030154905084565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461075657600080fd5b6001805461076491906110a7565b6001819055506000604051806080016040528060015481526020018573ffffffffffffffffffffffffffffffffffffffff168152602001848152602001838152509050600260008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190806001815401808255809150506001900390600052602060002090600402016000909190919091506000820151816000015560208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550604082015181600201908051906020019061087d929190610941565b506060820151816003015550507f2728c9d3205d667bbc0eefdfeda366261b4d021949630c047f3e5834b30611ab336001546040516108bd9291906110fd565b60405180910390a150505050565b6000600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020805490509050919050565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60015481565b82805461094d90610ffd565b90600052602060002090601f01602090048101928261096f57600085556109b6565b82601f1061098857805160ff19168380011785556109b6565b828001600101855582156109b6579182015b828111156109b557825182559160200191906001019061099a565b5b5090506109c391906109eb565b5090565b50805460008255600402906000526020600020908101906109e89190610a08565b50565b5b80821115610a045760008160009055506001016109ec565b5090565b5b80821115610a62576000808201600090556001820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff0219169055600282016000610a519190610a66565b600382016000905550600401610a09565b5090565b508054610a7290610ffd565b6000825580601f10610a845750610aa3565b601f016020900490600052602060002090810190610aa291906109eb565b5b50565b6000604051905090565b600080fd5b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000610ae582610aba565b9050919050565b610af581610ada565b8114610b0057600080fd5b50565b600081359050610b1281610aec565b92915050565b6000819050919050565b610b2b81610b18565b8114610b3657600080fd5b50565b600081359050610b4881610b22565b92915050565b60008060408385031215610b6557610b64610ab0565b5b6000610b7385828601610b03565b9250506020610b8485828601610b39565b9150509250929050565b6000610b9982610aba565b9050919050565b610ba981610b8e565b8114610bb457600080fd5b50565b600081359050610bc681610ba0565b92915050565b600080600060608486031215610be557610be4610ab0565b5b6000610bf386828701610bb7565b9350506020610c0486828701610bb7565b9250506040610c1586828701610b39565b9150509250925092565b60008115159050919050565b610c3481610c1f565b82525050565b6000602082019050610c4f6000830184610c2b565b92915050565b60008060408385031215610c6c57610c6b610ab0565b5b6000610c7a85828601610bb7565b9250506020610c8b85828601610b39565b9150509250929050565b610c9e81610b18565b82525050565b610cad81610b8e565b82525050565b600081519050919050565b600082825260208201905092915050565b60005b83811015610ced578082015181840152602081019050610cd2565b83811115610cfc576000848401525b50505050565b6000601f19601f8301169050919050565b6000610d1e82610cb3565b610d288185610cbe565b9350610d38818560208601610ccf565b610d4181610d02565b840191505092915050565b6000608082019050610d616000830187610c95565b610d6e6020830186610ca4565b8181036040830152610d808185610d13565b9050610d8f6060830184610c95565b95945050505050565b600080fd5b600080fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b610dda82610d02565b810181811067ffffffffffffffff82111715610df957610df8610da2565b5b80604052505050565b6000610e0c610aa6565b9050610e188282610dd1565b919050565b600067ffffffffffffffff821115610e3857610e37610da2565b5b610e4182610d02565b9050602081019050919050565b82818337600083830152505050565b6000610e70610e6b84610e1d565b610e02565b905082815260208101848484011115610e8c57610e8b610d9d565b5b610e97848285610e4e565b509392505050565b600082601f830112610eb457610eb3610d98565b5b8135610ec4848260208601610e5d565b91505092915050565b600080600060608486031215610ee657610ee5610ab0565b5b6000610ef486828701610bb7565b935050602084013567ffffffffffffffff811115610f1557610f14610ab5565b5b610f2186828701610e9f565b9250506040610f3286828701610b39565b9150509250925092565b600060208284031215610f5257610f51610ab0565b5b6000610f6084828501610bb7565b91505092915050565b6000602082019050610f7e6000830184610c95565b92915050565b6000602082019050610f996000830184610ca4565b92915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b6000600282049050600182168061101557607f821691505b6020821081141561102957611028610fce565b5b50919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b600061106982610b18565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff82141561109c5761109b61102f565b5b600182019050919050565b60006110b282610b18565b91506110bd83610b18565b9250827fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff038211156110f2576110f161102f565b5b828201905092915050565b60006040820190506111126000830185610ca4565b61111f6020830184610c95565b939250505056fea2646970667358221220f1ff9562eec75b4c550aec2600a384b6b6d18a03846ad85b5571113803a6257764736f6c634300080a0033";

    public static final String FUNC___OWNERIMMOBILIERS = "__ownerImmobiliers";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_TOTALIMMOBILIER = "totalImmobilier";

    public static final String FUNC_ADDIMMOBILIER = "addImmobilier";

    public static final String FUNC_TRANSFERETHER = "transferEther";

    public static final String FUNC_TRANSFERIMMOBILIER = "transferImmobilier";

    public static final String FUNC_GETNOMBREOFIMMOBILIER = "getNombreOfImmobilier";

    public static final Event ADD_EVENT = new Event("Add", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event ETHERTRANSFER_EVENT = new Event("EtherTransfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected MyImmobilierContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MyImmobilierContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MyImmobilierContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MyImmobilierContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<AddEventResponse> getAddEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADD_EVENT, transactionReceipt);
        ArrayList<AddEventResponse> responses = new ArrayList<AddEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddEventResponse typedResponse = new AddEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._ID = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddEventResponse> addEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AddEventResponse>() {
            @Override
            public AddEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADD_EVENT, log);
                AddEventResponse typedResponse = new AddEventResponse();
                typedResponse.log = log;
                typedResponse._owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._ID = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddEventResponse> addEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADD_EVENT));
        return addEventFlowable(filter);
    }

    public List<EtherTransferEventResponse> getEtherTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ETHERTRANSFER_EVENT, transactionReceipt);
        ArrayList<EtherTransferEventResponse> responses = new ArrayList<EtherTransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EtherTransferEventResponse typedResponse = new EtherTransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._price = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<EtherTransferEventResponse> etherTransferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, EtherTransferEventResponse>() {
            @Override
            public EtherTransferEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ETHERTRANSFER_EVENT, log);
                EtherTransferEventResponse typedResponse = new EtherTransferEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._price = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<EtherTransferEventResponse> etherTransferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ETHERTRANSFER_EVENT));
        return etherTransferEventFlowable(filter);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._ID = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._ID = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public RemoteFunctionCall<Tuple4<BigInteger, String, String, BigInteger>> __ownerImmobiliers(String param0, BigInteger param1) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC___OWNERIMMOBILIERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple4<BigInteger, String, String, BigInteger>>(function,
                new Callable<Tuple4<BigInteger, String, String, BigInteger>>() {
                    @Override
                    public Tuple4<BigInteger, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, String, String, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> totalImmobilier() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALIMMOBILIER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> addImmobilier(String propertyOwner, String _N_titre, BigInteger _price) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDIMMOBILIER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(propertyOwner), 
                new org.web3j.abi.datatypes.Utf8String(_N_titre), 
                new org.web3j.abi.datatypes.generated.Uint256(_price)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferEther(String reciever, BigInteger _amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERETHER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(reciever), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferImmobilier(String _Buyer, String _propertyOwner, BigInteger _ID) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERIMMOBILIER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_Buyer), 
                new org.web3j.abi.datatypes.Address(_propertyOwner), 
                new org.web3j.abi.datatypes.generated.Uint256(_ID)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getNombreOfImmobilier(String _Holder) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETNOMBREOFIMMOBILIER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_Holder)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static MyImmobilierContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyImmobilierContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MyImmobilierContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyImmobilierContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MyImmobilierContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MyImmobilierContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MyImmobilierContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MyImmobilierContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MyImmobilierContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MyImmobilierContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<MyImmobilierContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MyImmobilierContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MyImmobilierContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MyImmobilierContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MyImmobilierContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MyImmobilierContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class AddEventResponse extends BaseEventResponse {
        public String _owner;

        public BigInteger _ID;
    }

    public static class EtherTransferEventResponse extends BaseEventResponse {
        public String _from;

        public String _to;

        public BigInteger _price;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String _from;

        public String _to;

        public BigInteger _ID;
    }
}
