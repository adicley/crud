
package com.atividade1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "realiza")
public class RealizaModel {
    
    @Id
    @Column(name = "transaction_id")
    private BigInteger transactionId;
    
    @Column(name = "pf_account_number")
    private String pfAccountNumber;
    
    @Column(name = "pj_account_number")
    private String pjAccountNumber;
    
}
