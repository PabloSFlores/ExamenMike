package mx.edu.utez.examen.controllers.user;

import mx.edu.utez.examen.dto.user.UserDto;
import mx.edu.utez.examen.models.transaction.Transaction;
import mx.edu.utez.examen.models.user.User;
import mx.edu.utez.examen.services.transaction.TransactionService;
import mx.edu.utez.examen.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-shop/user/")
@CrossOrigin(origins = {"*"})
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/")
    public List<User> getAll() {
        return this.service.getAll();
    }
    @GetMapping("/{id}")
    public User getOne(@PathVariable("id") Long id) {
        return this.service.getOne(id);
    }

    @PostMapping("/")
    public User save(@RequestBody UserDto user) {
        return this.service.insert(user.getUser());
    }
    @PutMapping("/")
    public User update(@RequestBody UserDto user) {
        return this.service.update(user.getUser());
    }
    @DeleteMapping("/{id}")
    public boolean update(@PathVariable("id") Long id) {
        return this.service.deleteOne(id);
    }
}
