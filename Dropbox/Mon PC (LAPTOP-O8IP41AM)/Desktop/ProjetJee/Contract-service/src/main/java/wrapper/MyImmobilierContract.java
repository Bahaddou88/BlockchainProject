package wrapper;

import com.example.models.Immobilier;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
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

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.Callable;

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
    public static final String BINARY = "0x608060405234801561001057600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060006001819055506114c9806100686000396000f3fe60806040526004361061007b5760003560e01c80637dcd1a2e1161004e5780637dcd1a2e146101355780638da5cb5b14610172578063b42fc8ac1461019d578063c1b8a1a5146101da5761007b565b806305b1137b1461008057806325cf53dc1461009c57806354eefe9c146100cc57806361192c1b1461010c575b600080fd5b61009a60048036038101906100959190610d0c565b610205565b005b6100b660048036038101906100b19190610d8a565b610250565b6040516100c39190610df8565b60405180910390f35b3480156100d857600080fd5b506100f360048036038101906100ee9190610e13565b6106af565b6040516101039493929190610f0a565b60405180910390f35b34801561011857600080fd5b50610133600480360381019061012e919061108b565b6107a4565b005b34801561014157600080fd5b5061015c600480360381019061015791906110fa565b610971565b6040516101699190611127565b60405180910390f35b34801561017e57600080fd5b506101876109bd565b6040516101949190611142565b60405180910390f35b3480156101a957600080fd5b506101c460048036038101906101bf91906110fa565b6109e1565b6040516101d191906112ea565b60405180910390f35b3480156101e657600080fd5b506101ef610b7b565b6040516101fc9190611127565b60405180910390f35b8173ffffffffffffffffffffffffffffffffffffffff166108fc829081150290604051600060405180830381858888f1935050505015801561024b573d6000803e3d6000fd5b505050565b600080600090505b600260008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020805490508110156106a25782600260008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002082815481106102f4576102f361130c565b5b906000526020600020906004020160000154141561068f57600060405180608001604052808581526020018773ffffffffffffffffffffffffffffffffffffffff168152602001600260008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020848154811061038c5761038b61130c565b5b906000526020600020906004020160020180546103a89061136a565b80601f01602080910402602001604051908101604052809291908181526020018280546103d49061136a565b80156104215780601f106103f657610100808354040283529160200191610421565b820191906000526020600020905b81548152906001019060200180831161040457829003601f168201915b50505050508152602001600260008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020848154811061047c5761047b61130c565b5b9060005260206000209060040201600301548152509050600260008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190806001815401808255809150506001900390600052602060002090600402016000909190919091506000820151816000015560208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506040820151816002019080519060200190610569929190610b81565b50606082015181600301555050600260008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002082815481106105c7576105c661130c565b5b90600052602060002090600402016000808201600090556001820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff02191690556002820160006106159190610c07565b600382016000905550508573ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef8660405161067c9190611127565b60405180910390a36001925050506106a8565b808061069a906113cb565b915050610258565b50600090505b9392505050565b600260205281600052604060002081815481106106cb57600080fd5b9060005260206000209060040201600091509150508060000154908060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169080600201805461071b9061136a565b80601f01602080910402602001604051908101604052809291908181526020018280546107479061136a565b80156107945780601f1061076957610100808354040283529160200191610794565b820191906000526020600020905b81548152906001019060200180831161077757829003601f168201915b5050505050908060030154905084565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146107fc57600080fd5b6001805461080a9190611414565b6001819055506000604051806080016040528060015481526020018573ffffffffffffffffffffffffffffffffffffffff168152602001848152602001838152509050600260008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190806001815401808255809150506001900390600052602060002090600402016000909190919091506000820151816000015560208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506040820151816002019080519060200190610923929190610b81565b506060820151816003015550507f2728c9d3205d667bbc0eefdfeda366261b4d021949630c047f3e5834b30611ab3360015460405161096392919061146a565b60405180910390a150505050565b6000600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020805490509050919050565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6060600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020805480602002602001604051908101604052809291908181526020016000905b82821015610b705783829060005260206000209060040201604051806080016040529081600082015481526020016001820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001600282018054610ad59061136a565b80601f0160208091040260200160405190810160405280929190818152602001828054610b019061136a565b8015610b4e5780601f10610b2357610100808354040283529160200191610b4e565b820191906000526020600020905b815481529060010190602001808311610b3157829003601f168201915b5050505050815260200160038201548152505081526020019060010190610a42565b505050509050919050565b60015481565b828054610b8d9061136a565b90600052602060002090601f016020900481019282610baf5760008555610bf6565b82601f10610bc857805160ff1916838001178555610bf6565b82800160010185558215610bf6579182015b82811115610bf5578251825591602001919060010190610bda565b5b509050610c039190610c47565b5090565b508054610c139061136a565b6000825580601f10610c255750610c44565b601f016020900490600052602060002090810190610c439190610c47565b5b50565b5b80821115610c60576000816000905550600101610c48565b5090565b6000604051905090565b600080fd5b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000610ca382610c78565b9050919050565b610cb381610c98565b8114610cbe57600080fd5b50565b600081359050610cd081610caa565b92915050565b6000819050919050565b610ce981610cd6565b8114610cf457600080fd5b50565b600081359050610d0681610ce0565b92915050565b60008060408385031215610d2357610d22610c6e565b5b6000610d3185828601610cc1565b9250506020610d4285828601610cf7565b9150509250929050565b6000610d5782610c78565b9050919050565b610d6781610d4c565b8114610d7257600080fd5b50565b600081359050610d8481610d5e565b92915050565b600080600060608486031215610da357610da2610c6e565b5b6000610db186828701610d75565b9350506020610dc286828701610d75565b9250506040610dd386828701610cf7565b9150509250925092565b60008115159050919050565b610df281610ddd565b82525050565b6000602082019050610e0d6000830184610de9565b92915050565b60008060408385031215610e2a57610e29610c6e565b5b6000610e3885828601610d75565b9250506020610e4985828601610cf7565b9150509250929050565b610e5c81610cd6565b82525050565b610e6b81610d4c565b82525050565b600081519050919050565b600082825260208201905092915050565b60005b83811015610eab578082015181840152602081019050610e90565b83811115610eba576000848401525b50505050565b6000601f19601f8301169050919050565b6000610edc82610e71565b610ee68185610e7c565b9350610ef6818560208601610e8d565b610eff81610ec0565b840191505092915050565b6000608082019050610f1f6000830187610e53565b610f2c6020830186610e62565b8181036040830152610f3e8185610ed1565b9050610f4d6060830184610e53565b95945050505050565b600080fd5b600080fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b610f9882610ec0565b810181811067ffffffffffffffff82111715610fb757610fb6610f60565b5b80604052505050565b6000610fca610c64565b9050610fd68282610f8f565b919050565b600067ffffffffffffffff821115610ff657610ff5610f60565b5b610fff82610ec0565b9050602081019050919050565b82818337600083830152505050565b600061102e61102984610fdb565b610fc0565b90508281526020810184848401111561104a57611049610f5b565b5b61105584828561100c565b509392505050565b600082601f83011261107257611071610f56565b5b813561108284826020860161101b565b91505092915050565b6000806000606084860312156110a4576110a3610c6e565b5b60006110b286828701610d75565b935050602084013567ffffffffffffffff8111156110d3576110d2610c73565b5b6110df8682870161105d565b92505060406110f086828701610cf7565b9150509250925092565b6000602082840312156111105761110f610c6e565b5b600061111e84828501610d75565b91505092915050565b600060208201905061113c6000830184610e53565b92915050565b60006020820190506111576000830184610e62565b92915050565b600081519050919050565b600082825260208201905092915050565b6000819050602082019050919050565b61119281610cd6565b82525050565b6111a181610d4c565b82525050565b600082825260208201905092915050565b60006111c382610e71565b6111cd81856111a7565b93506111dd818560208601610e8d565b6111e681610ec0565b840191505092915050565b60006080830160008301516112096000860182611189565b50602083015161121c6020860182611198565b506040830151848203604086015261123482826111b8565b91505060608301516112496060860182611189565b508091505092915050565b600061126083836111f1565b905092915050565b6000602082019050919050565b60006112808261115d565b61128a8185611168565b93508360208202850161129c85611179565b8060005b858110156112d857848403895281516112b98582611254565b94506112c483611268565b925060208a019950506001810190506112a0565b50829750879550505050505092915050565b600060208201905081810360008301526113048184611275565b905092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b6000600282049050600182168061138257607f821691505b602082108114156113965761139561133b565b5b50919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b60006113d682610cd6565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8214156114095761140861139c565b5b600182019050919050565b600061141f82610cd6565b915061142a83610cd6565b9250827fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff0382111561145f5761145e61139c565b5b828201905092915050565b600060408201905061147f6000830185610e62565b61148c6020830184610e53565b939250505056fea264697066735822122070c0aee3769865d44addbde7bdcb512a28af32febab9cb50f8cb5946e8c156ea64736f6c634300080a0033";

    public static final String FUNC___OWNERIMMOBILIERS = "__ownerImmobiliers";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_TOTALIMMOBILIER = "totalImmobilier";

    public static final String FUNC_ADDIMMOBILIER = "addImmobilier";

    public static final String FUNC_TRANSFERETHER = "transferEther";

    public static final String FUNC_TRANSFERIMMOBILIER = "transferImmobilier";

    public static final String FUNC_GETIMMOBILIERFROMHOLDER = "getImmobilierFromHolder";

    public static final String FUNC_GETNOMBREOFIMMOBILIER = "getNombreOfImmobilier";

    public static final Event ADD_EVENT = new Event("Add",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
            }, new TypeReference<Uint256>() {
            }));
    ;

    public static final Event ETHERTRANSFER_EVENT = new Event("EtherTransfer",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Uint256>() {
            }));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Uint256>() {
            }));
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
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
                }, new TypeReference<Address>() {
                }, new TypeReference<Utf8String>() {
                }, new TypeReference<Uint256>() {
                }));
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
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
                }));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> totalImmobilier() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALIMMOBILIER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
                }));
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

    public RemoteFunctionCall<List> getImmobilierFromHolder(String _Holder) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETIMMOBILIERFROMHOLDER,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_Holder)),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Immobilier>>() {
                }));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getNombreOfImmobilier(String _Holder) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETNOMBREOFIMMOBILIER,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_Holder)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
                }));
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
