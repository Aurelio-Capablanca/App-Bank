package com.bankapp.bank.Models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
@ToString
@EqualsAndHashCode
public class transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    @Setter
    @Column(name = "id_transaction ")
    private int id_transaction;

    @Getter
    @Setter
    @Column(name = "name_transaction")
    private String name_transaction;

    @Getter
    @Setter
    @Column(name = "date_transaction")
    private String date_transaction;//tipo de dato en la base de datos DATE --- Autogenerado

    @Getter
    @Setter
    @Column(name = "balance_transaction")
    private double balance_transaction;

    @Getter
    @Setter
    @Column(name = "total_transaction")
    private double total_transaction;

    @Getter
    @Setter
    @Column(name = "id_typetransaction ")
    private int id_typetransaction;

    @Getter
    @Setter
    @Column(name = "id_statustransaction ")
    private int id_statustransaction;


}
