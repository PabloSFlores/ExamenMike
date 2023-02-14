package mx.edu.utez.examen.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examen.models.transaction.Transaction;
import mx.edu.utez.examen.models.user.User;

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
public class UserDto {
    private Long id;
    @NotEmpty(message = "Campo obligatorio")
    @Size(min = 1, max = 100)
    private String fullname;
    @NotEmpty(message = "Campo obligatorio")
    @Size(min = 1, max = 100)
    private String email;
    @NotEmpty(message = "Campo obligatorio")
    @Size(min = 1, max = 50)
    private String password;
    @NotEmpty(message = "Campo obligatorio")
    private String wish_list;
    private List<Transaction> transactions;

    public User getUser() {
        return new User(
                getId(),
                getFullname(),
                getEmail(),
                getEmail(),
                getWish_list(),
                getTransactions()
        );
    }
}
