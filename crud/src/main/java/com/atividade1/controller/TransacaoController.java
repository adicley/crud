
package com.atividade1.controller;

import com.atividade1.model.TransacaoModel;
import com.atividade1.service.TransacaoService;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/transacao")
public class TransacaoController {
    
    private TransacaoService service;
    
    @PostMapping
    public ResponseEntity createTransaction(@RequestBody TransacaoModel model){
        if (service.existsTransaction(model))
            return new ResponseEntity<>("Nao foi possivel criar a transacao.", HttpStatus.BAD_REQUEST);
        
        service.save(model);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }
    
    @GetMapping("/{transactionId}")
    public ResponseEntity readTransaction(@PathVariable BigInteger transactionId){
        TransacaoModel model = new TransacaoModel();
        
        model.setTransactionId(transactionId);
        
        Optional conta = service.read(model);
        
        if (conta.isEmpty())
            return new ResponseEntity<>("Transacao nao encontrada.", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(conta, HttpStatus.FOUND);
    }
    
    @GetMapping("/listAll")
    public List<TransacaoModel> listAll(){
        return service.realAll();
    }
    
    @PutMapping
    public ResponseEntity updateAccount(@RequestBody TransacaoModel model){
        if (!service.existsTransaction(model))
            return new ResponseEntity<>("Transacao nao encontrada.", HttpStatus.NOT_FOUND);
        
        service.save(model);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
    
    @DeleteMapping
    public ResponseEntity deleteAccount(@RequestBody TransacaoModel model){
        if (!service.existsTransaction(model))
            return new ResponseEntity<>("Transacao nao encontrada.", HttpStatus.NOT_FOUND);
        
        service.delete(model);
        return new ResponseEntity<>("Transacao deletada com sucesso.", HttpStatus.OK);
    }
}
