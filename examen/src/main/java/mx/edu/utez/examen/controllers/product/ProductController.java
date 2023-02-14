package mx.edu.utez.examen.controllers.product;

import mx.edu.utez.examen.dto.product.ProductDto;
import mx.edu.utez.examen.models.product.Product;
import mx.edu.utez.examen.models.transaction.Transaction;
import mx.edu.utez.examen.services.product.ProductService;
import mx.edu.utez.examen.services.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-shop/product/")
@CrossOrigin(origins = {"*"})
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/")
    public List<Product> getAll() {
        return this.service.getAll();
    }
    @GetMapping("/{id}")
    public Product getOne(@PathVariable("id") Long id) {
        return this.service.getOne(id);
    }

    @PostMapping("/")
    public Product save(@RequestBody ProductDto product) {
        return this.service.insert(product.getProduct());
    }
    @PutMapping("/")
    public Product update(@RequestBody ProductDto product) {
        return this.service.update(product.getProduct());
    }

    @PatchMapping("/")
    public boolean changeStatus(@RequestBody  Long id){
        Product product = this.service.getOne(id);
        if (product==null){
            return false;
        }
        return this.service.changeStatus(product);
    }
}
