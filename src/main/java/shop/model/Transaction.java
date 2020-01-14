package shop.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = Client.class)
    private Client client;

    @ManyToOne(targetEntity = Seller.class)
    private Seller seller;

    @ManyToOne(targetEntity = Gun.class)
    private Gun gun;

    private LocalDateTime timeOfTransaction;

}
