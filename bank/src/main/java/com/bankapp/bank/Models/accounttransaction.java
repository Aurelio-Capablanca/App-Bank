package bank.Models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "accounttransaction")
@ToString
@EqualsAndHashCode
public class accounttransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    @Setter
    @Column(name = "id_account")
    private int id_account;

    @Getter
    @Setter
    @Column(name = "id_transaction")
    private int id_transaction;

}
