package com.bankapp.bank.Models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "typetransaction")
@ToString
@EqualsAndHashCode
public class typetransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    @Setter
    @Column(name = "id_typetransaction ")
    private int id_typetransaction;

    @Getter
    @Setter
    @Column(name = "type_transaction")
    private String type_transaction;
}
