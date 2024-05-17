package org.example.ebanking_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.example.ebanking_backend.enums.OperationType;

import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountOperation {

     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private Date operationDate;

    private double ammount ;
    @Enumerated(EnumType.STRING)
    private OperationType type ;


    @ManyToOne
    private BankAccount bankAccount;

    private String description;
}
