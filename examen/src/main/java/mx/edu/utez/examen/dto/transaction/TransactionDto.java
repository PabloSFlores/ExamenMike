package mx.edu.utez.examen.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examen.models.product.Product;
import mx.edu.utez.examen.models.transaction.Transaction;
import mx.edu.utez.examen.models.user.User;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionDto {
    private Long id;
    private String purchase_date;

    @NotEmpty(message = "Campo obligatorio")
    private User user;

    @NotEmpty(message = "Campo obligatorio")
    private Product products;

    public Transaction getTransaction(){
        return new Transaction(
                getId(),
                getPurchase_date(),
                getUser(),
                getProducts()
        );
    }
}
