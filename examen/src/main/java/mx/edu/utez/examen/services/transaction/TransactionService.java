package mx.edu.utez.examen.services.transaction;

import mx.edu.utez.examen.models.product.Product;
import mx.edu.utez.examen.models.product.ProductRepository;
import mx.edu.utez.examen.models.transaction.Transaction;
import mx.edu.utez.examen.models.transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    @Transactional(readOnly = true)
    public List<Transaction> getAll(){
        return this.repository.findAll();
    }
    @Transactional(readOnly = true)
    public Transaction getOne(Long id){
        return this.repository.findById(id).get();
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Transaction insert (Transaction transaction) {
        return this.repository.saveAndFlush(transaction);
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Transaction update (Transaction transaction) {
        return this.repository.saveAndFlush(transaction);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public boolean deleteOne(Long id){
        if (!(this.repository.existsById(id))){
            return false;
        }
        this.repository.deleteById((id));
        return true;
    }
}
