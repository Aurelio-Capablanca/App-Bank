/*package com.bankapp.bank.Models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "historytransaction")
@ToString
@EqualsAndHashCode
public class historytransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    @Setter
    @Column(name = "id_transaction_history")
    private int id_transaction_history;

    @Getter
    @Setter
    @Column(name = "name_transaction_history")
    private String name_transaction_history;

    @Getter
    @Setter
    @Column(name = "date_transaction_history")
    private String date_transaction_history; //tipo de dato en la base de datos DATE

    @Getter
    @Setter
    @Column(name = "balance_transaction_history")
    private double balance_transaction_history;

    @Getter
    @Setter
    @Column(name = "total_transaction_history")
    private double total_transaction_history;

    @Getter
    @Setter
    @Column(name = "id_typetransaction_history")
    private int id_typetransaction_history;

    @Getter
    @Setter
    @Column(name = "id_statustransaction_history")
    private int id_statustransaction_history;

    @Getter
    @Setter
    @Column(name = "id_original_transaction")
    private int id_original_transaction;

}
*/