package com.bankapp.bank.Models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
@ToString
@EqualsAndHashCode
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id_transaction ")
    private Long id_transaction;

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
    @Column(name = "id_typetransaction")
    private int id_typetransaction;

    @Getter
    @Setter
    @Column(name = "id_statustransaction")
    private int id_statustransaction;


}
