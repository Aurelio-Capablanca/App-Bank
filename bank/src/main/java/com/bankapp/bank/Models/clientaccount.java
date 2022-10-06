package com.bankapp.bank.Models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "clientaccount")
@ToString
@EqualsAndHashCode
public class clientaccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    @Setter
    @Column(name = "id_client")
    private int id_client;

    @Getter
    @Setter
    @Column(name = "id_account")
    private int id_account;


}
