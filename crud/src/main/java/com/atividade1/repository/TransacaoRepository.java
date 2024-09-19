package com.atividade1.repository;

import com.atividade1.model.TransacaoModel;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<TransacaoModel, BigInteger>{
    
}
