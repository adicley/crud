
package com.atividade1.repository;
import com.atividade1.model.RealizaModel;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealizaRepository extends JpaRepository<RealizaModel, BigInteger>{
    
}

