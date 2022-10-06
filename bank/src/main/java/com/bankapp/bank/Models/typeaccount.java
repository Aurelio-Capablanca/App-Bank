package com.bankapp.bank.Models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "typeaccount")
@ToString
@EqualsAndHashCode
public class typeaccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    @Setter
    @Column(name = "id_typeaccount ")
    private int id_typeaccount;

    @Getter
    @Setter
    @Column(name = "type_account")
    private String type_account;
}
