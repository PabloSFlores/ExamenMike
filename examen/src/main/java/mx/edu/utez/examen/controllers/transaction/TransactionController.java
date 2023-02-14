package mx.edu.utez.examen.controllers.transaction;

import mx.edu.utez.examen.dto.transaction.TransactionDto;
import mx.edu.utez.examen.models.transaction.Transaction;
import mx.edu.utez.examen.services.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-shop/transaction/")
@CrossOrigin(origins = {"*"})
public class TransactionController {
    @Autowired
    private TransactionService service;

    @GetMapping("/")
    public List<Transaction> getAll() {
        return this.service.getAll();
    }
    @GetMapping("/{id}")
    public Transaction getOne(@PathVariable("id") Long id) {
        return this.service.getOne(id);
    }

    @PostMapping("/")
    public Transaction save(@RequestBody TransactionDto transaction) {
        return this.service.insert(transaction.getTransaction());
    }
    @PutMapping("/")
    public Transaction update(@RequestBody TransactionDto transaction) {
        return this.service.update(transaction.getTransaction());
    }
    @DeleteMapping("/{id}")
    public boolean update(@PathVariable("id") Long id) {
        return this.service.deleteOne(id);
    }
}
