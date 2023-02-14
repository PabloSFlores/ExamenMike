package mx.edu.utez.examen.services.product;

import mx.edu.utez.examen.models.product.Product;
import mx.edu.utez.examen.models.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<Product> getAll(){
        return this.repository.findAll();
    }
    @Transactional(readOnly = true)
    public Product getOne(Long id){
        return this.repository.findById(id).get();
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Product insert (Product product) {
        return this.repository.saveAndFlush(product);
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Product update (Product product) {
        return this.repository.saveAndFlush(product);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public boolean changeStatus (Product product) {
        return this.repository.updateStatusById(product.getDisponibility(), product.getId())>0;
    }

}
