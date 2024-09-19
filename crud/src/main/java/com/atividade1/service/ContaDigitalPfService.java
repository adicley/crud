
package com.atividade1.service;

import com.atividade1.model.ContaDigitalPfModel;
import com.atividade1.repository.ContaDigitalPfRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContaDigitalPfService {
    
    @Autowired
    private ContaDigitalPfRepository contaRepository;
    
    public ContaDigitalPfModel save(ContaDigitalPfModel model){
        return contaRepository.save(model);
    }
    
    public boolean existsAccountNumber(ContaDigitalPfModel model){
        return contaRepository.existsById(model.getPfAccountNumber());
    }
    
    public Optional<ContaDigitalPfModel> read(ContaDigitalPfModel model){
        return contaRepository.findById(model.getPfAccountNumber());
    }
    
    public List<ContaDigitalPfModel> realAll(){
        return contaRepository.findAll();
    }
    
    public void delete(ContaDigitalPfModel model){
        contaRepository.deleteById(model.getPfAccountNumber());
    }
}
