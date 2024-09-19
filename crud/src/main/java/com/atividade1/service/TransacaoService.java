
package com.atividade1.service;

import com.atividade1.model.TransacaoModel;
import com.atividade1.repository.TransacaoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {
    
    @Autowired
    private TransacaoRepository transacaoRepository;
    
    public TransacaoModel save(TransacaoModel model){
        return transacaoRepository.save(model);
    }
    
    public boolean existsTransaction(TransacaoModel model){
        return transacaoRepository.existsById(model.getTransactionId());
    }
    
    public Optional<TransacaoModel> read(TransacaoModel model){
        return transacaoRepository.findById(model.getTransactionId());
    }
    
    public List<TransacaoModel> realAll(){
        return transacaoRepository.findAll();
    }
    
    public void delete(TransacaoModel model){
        transacaoRepository.deleteById(model.getTransactionId());
    }
}
