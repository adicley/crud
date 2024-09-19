
package com.atividade1.controller;

import com.atividade1.model.ContaDigitalPfModel;
import com.atividade1.service.ContaDigitalPfService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/contapf")
public class ContaPfController {
    
    private ContaDigitalPfService service;
    
    @PostMapping
    public ResponseEntity createAccount(@RequestBody ContaDigitalPfModel model){
        if (service.existsAccountNumber(model))
            return new ResponseEntity<>("Nao foi possivel criar a conta pf.", HttpStatus.BAD_REQUEST);
        
        service.save(model);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity readAccount(@RequestBody ContaDigitalPfModel model){
        Optional conta = service.read(model);
        
        if (conta.isEmpty())
            return new ResponseEntity<>("Conta nao encontrada.", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(conta, HttpStatus.FOUND);
    }
    
    @GetMapping("/listAll")
    public List<ContaDigitalPfModel> listAll(){
        return service.realAll();
    }
    
    @PutMapping
    public ResponseEntity updateAccount(@RequestBody ContaDigitalPfModel model){
        if (!service.existsAccountNumber(model))
            return new ResponseEntity<>("Conta nao encontrada.", HttpStatus.NOT_FOUND);
        
        service.save(model);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
    
    @DeleteMapping
    public ResponseEntity deleteAccount(@RequestBody ContaDigitalPfModel model){
        if (!service.existsAccountNumber(model))
            return new ResponseEntity<>("Conta nao encontrada.", HttpStatus.NOT_FOUND);
        
        service.delete(model);
        return new ResponseEntity<>("Conta pf deletada com sucesso.", HttpStatus.OK);
    }
}
