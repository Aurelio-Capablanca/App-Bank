package com.bankapp.bank.Models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "clients")
@ToString
@EqualsAndHashCode
public class clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    @Setter
    @Column(name = "id_client")
    private int id_client;

    @Getter
    @Setter
    @Column(name = "name_client")
    private String name_client;

    @Getter
    @Setter
    @Column(name = "surname_client")
    private String surname_client;

    @Getter
    @Setter
    @Column(name = "phone_client")
    private String phone_client;

    @Getter
    @Setter
    @Column(name = "email_client")
    private String email_client;

    @Getter
    @Setter
    @Column(name = "dni_client")
    private String dni_client;

    @Getter
    @Setter
    @Column(name = "user_client")
    private String user_client;

    @Getter
    @Setter
    @Column(name = "password_client")
    private String password_client;

    @Getter
    @Setter
    @Column(name = "id_statusclient")
    private int id_statusclient;


}
