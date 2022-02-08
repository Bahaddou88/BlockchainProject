//SPDX-License-Identifier: UNLICENSED
pragma solidity >=0.6.10 <0.9.0;


contract MyImmobilierContract
{
    struct Immobilier
    {
        uint ID;
        address ownerAddress;
        string N_titre;
        uint price;
    }

    address public owner;  // l'admin, le créateur du contract

    uint public totalImmobilier;  //le nombre total des immobiliers

    //definer le propriétaire
    constructor() {
        owner = msg.sender;
        totalImmobilier = 0; // initialise le nombre des imm par 0 au départ
    }

    //immobilier addition event
    event Add(address _owner, uint _ID);
    //immobiliers transfer event
    event Transfer(address indexed _from, address indexed _to, uint _ID);
    // immobiliers Ether Transfer
    event EtherTransfer(address indexed _from, address indexed _to, uint _price);

    //one account can hold many lands (many landTokens, each token one land)
    mapping (address => Immobilier[]) public __ownerImmobiliers;

    modifier isOwner
    {
        require(msg.sender == owner);
        _;
    }

    //1. FIRST OPERATION
    //owner shall add lands via this function
    function addImmobilier(address propertyOwner,string memory _N_titre, uint _price) public isOwner
    {
        totalImmobilier = totalImmobilier + 1;
        Immobilier memory MyImmobilier = Immobilier(
        {
        ownerAddress: propertyOwner,
        N_titre: _N_titre,
        price: _price,
        ID: totalImmobilier
        });
        __ownerImmobiliers[propertyOwner].push(MyImmobilier);
        emit Add(msg.sender, totalImmobilier);
    }

    function transferEther(address payable reciever,uint _amount) public payable {
        reciever.transfer(_amount);
    }
    

    //2. SECOND OP\\ERATION
    //caller (owner/anyone) to transfer land to buyer provided caller is owner of the land
    function transferImmobilier(address _Buyer,address _propertyOwner, uint _ID) payable public returns (bool)
    {

        //if given land ID is indeed in owner's collection
        for(uint i=0; i < (__ownerImmobiliers[_propertyOwner].length);i++)
        {
            if (__ownerImmobiliers[_propertyOwner][i].ID == _ID)
            {

                Immobilier memory myImmobilier= Immobilier(
                {
                ownerAddress:_Buyer,
                N_titre: __ownerImmobiliers[_propertyOwner][i].N_titre,
                price: __ownerImmobiliers[_propertyOwner][i].price,
                ID: _ID
                });

                __ownerImmobiliers[_Buyer].push(myImmobilier);

                delete __ownerImmobiliers[_propertyOwner][i];      // ici on supprimer l'immobilier pour _propertyOwner // il faut add i to array

                emit Transfer(msg.sender, _Buyer, _ID);

                return true;
            }
        }

        return false;

    }
    //3. THIRD OPERATION
        //get land details of an account
        function getImmobilierFromHolder(address _Holder) public view returns (Immobilier[] memory)
        {
            return __ownerImmobiliers[_Holder];
        }
    //4. GET TOTAL NO OF LANDS OWNED BY AN ACCOUNT AS NO WAY TO RETURN STRUCT ARRAYS
    function getNombreOfImmobilier(address _Holder) public view returns (uint)
    {
        return __ownerImmobiliers[_Holder].length;
    }
}
