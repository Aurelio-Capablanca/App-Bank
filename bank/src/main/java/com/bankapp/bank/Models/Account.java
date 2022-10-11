package com.bankapp.bank.Models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "account")
@ToString
@EqualsAndHashCode
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id_account")
    private Long id_account;

    @Getter
    @Setter
    @Column(name = "number_account")
    private String number_account;

    @Getter
    @Setter
    @Column(name = "balance_account")
    private static double balance_account;

    @Getter
    @Setter
    @Column(name = "id_typeaccount")
    private int id_typeaccount;

    @Getter
    @Setter
    @Column(name = "id_statusaccount")
    private int id_statusaccount;

}
