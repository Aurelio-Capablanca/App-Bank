package bank.Models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "dbbank")
@ToString
@EqualsAndHashCode
public class statustransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    @Setter
    @Column(name = "id_statustransaction")
    private int id_statustransaction;

    @Getter
    @Setter
    @Column(name = "status_transaction")
    private String status_transaction;
}
