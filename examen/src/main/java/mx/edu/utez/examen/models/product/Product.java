package mx.edu.utez.examen.models.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examen.models.transaction.Transaction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String product_name;
    @Column()
    private String category;
    @Column()
    private Double price;
    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean disponibility;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Transaction> transactions;
}
