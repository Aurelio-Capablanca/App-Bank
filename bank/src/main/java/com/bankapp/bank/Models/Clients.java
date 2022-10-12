package com.bankapp.bank.Models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "clients")
@NoArgsConstructor
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id_client")
    private Long id_client;

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


    public Clients(String name_client, String surname_client, String phone_client, String email_client, String dni_client, String user_client,int id_statusclient) {
        this.name_client = name_client;
        this.surname_client = surname_client;
        this.phone_client = phone_client;
        this.email_client = email_client;
        this.dni_client = dni_client;
        this.user_client = user_client;
        this.id_statusclient = id_statusclient;
    }



}
