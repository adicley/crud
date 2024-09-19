
package com.atividade1.controller;

import com.atividade1.model.RealizaModel;
import com.atividade1.service.RealizaService;
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
@RequestMapping("/api/realiza")
public class RealizaController {
    
    private RealizaService service;
    
    @PostMapping
    public ResponseEntity createBond(@RequestBody RealizaModel model){
        if (service.existsTransaction(model))
            return new ResponseEntity<>("Nao foi possivel vincular a transacao.", HttpStatus.BAD_REQUEST);
        
        service.save(model);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }
    
    @GetMapping("/{transactionId}")
    public ResponseEntity readBond(@PathVariable BigInteger transactionId){
        RealizaModel model = new RealizaModel();
        model.setTransactionId(transactionId);
        
        Optional conta = service.read(model);
        
        if (conta.isEmpty())
            return new ResponseEntity<>("Vinculo de transacao nao encontrado.", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(conta, HttpStatus.FOUND);
    }
    
    @GetMapping("/listAll")
    public List<RealizaModel> listAll(){
        return service.realAll();
    }
    
    @PutMapping
    public ResponseEntity updateBond(@RequestBody RealizaModel model){
        if (!service.existsTransaction(model))
            return new ResponseEntity<>("Vinculo de transacao nao encontrado.", HttpStatus.NOT_FOUND);
        
        service.save(model);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
    
    @DeleteMapping
    public ResponseEntity deleteBond(@RequestBody RealizaModel model){
        if (!service.existsTransaction(model))
            return new ResponseEntity<>("Vinculo de transacao nao encontrado para deleção.", HttpStatus.NOT_FOUND);
        
        service.delete(model);
        return new ResponseEntity<>("Vinculo de transacao deletada com sucesso.", HttpStatus.OK);
    }
}
