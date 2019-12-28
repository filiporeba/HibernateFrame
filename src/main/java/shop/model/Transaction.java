package shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {

    //TODO Manyto... for other entities


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;
//    private Client transactionClient;
//    private Seller transactionSeller;
//    private Gun transactionGun;


    public Transaction() {
    }


}
