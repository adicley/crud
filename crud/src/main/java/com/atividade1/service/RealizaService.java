
package com.atividade1.service;

import com.atividade1.model.RealizaModel;
import com.atividade1.repository.RealizaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealizaService {
    
    @Autowired
    private RealizaRepository realizaRepository;
    
    public RealizaModel save(RealizaModel model){
        return realizaRepository.save(model);
    }
    
    public boolean existsTransaction(RealizaModel model){
        return realizaRepository.existsById(model.getTransactionId());
    }
    
    public Optional<RealizaModel> read(RealizaModel model){
        return realizaRepository.findById(model.getTransactionId());
    }
    
    public List<RealizaModel> realAll(){
        return realizaRepository.findAll();
    }
    
    public void delete(RealizaModel model){
        realizaRepository.deleteById(model.getTransactionId());
    }
}
