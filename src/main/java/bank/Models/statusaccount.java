package bank.Models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "dbbank")
@ToString
@EqualsAndHashCode
public class statusaccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    @Setter
    @Column(name = "id_statusaccount")
    private int id_statusaccount;

    @Getter
    @Setter
    @Column(name = "status_account")
    private String status_account;
}
