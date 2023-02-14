package mx.edu.utez.examen.models.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {
    @Modifying
    @Query(value = "UPDATE products SET disponibility = :disponibility WHERE id = :id", nativeQuery = true)
    int updateStatusById(
            @Param("disponibility") Boolean disponibility,
            @Param("id")Long id);
}
