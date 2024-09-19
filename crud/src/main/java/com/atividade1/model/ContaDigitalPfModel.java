
package com.atividade1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "conta_digital_pf")
public class ContaDigitalPfModel {
    
    @Id
    @Column(name = "pf_account_number")
    private String pfAccountNumber;
    
    @Column(name = "birthday")
    private LocalDate birthday;
    
    @Column(name = "cpf")
    private String cpf;

}
