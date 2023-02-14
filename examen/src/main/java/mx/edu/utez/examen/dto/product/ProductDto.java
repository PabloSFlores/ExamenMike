package mx.edu.utez.examen.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examen.models.product.Product;
import mx.edu.utez.examen.models.transaction.Transaction;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Long id;

    @NotEmpty(message = "Campo obligatorio")
    @Size(min = 1, max = 100)
    private String product_name;

    @NotEmpty(message = "Campo obligatorio")
    @Size(min = 1, max = 50)
    private String category;
    @NotEmpty(message = "Campo obligatorio")
    private Double price;
    private Boolean disponibility;
    private List<Transaction> transactions;

    public Product getProduct(){
        return new Product(
          getId(),
          getProduct_name(),
          getCategory(),
          getPrice(),
          getDisponibility(),
          getTransactions()
        );
    }
}
