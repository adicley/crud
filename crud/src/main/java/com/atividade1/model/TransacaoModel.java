
package com.atividade1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transacao")
public class TransacaoModel {

    @Id
    @Column(name = "transaction_id")
    private BigInteger transactionId;
    
    @Column(name = "value")
    private float value;
    
    @Column(name = "transaction_date")
    private LocalDate transactionDate;
    
}
