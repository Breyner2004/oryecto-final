package com.corhuila.shoppingcar.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.corhuila.shoppingcar.Document.Cliente;
import com.corhuila.shoppingcar.IService.IClienteService;
import com.corhuila.shoppingcar.DTO.CredencialesDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    @Autowired
    private IClienteService service;

    @GetMapping()
    public List<Cliente> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping()
    public Cliente save(@RequestBody Cliente cliente) {
        return service.save(cliente);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Cliente cliente, @PathVariable String id) {
        service.update(cliente, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping("/validar")
    public ResponseEntity<?> validarCredenciales(@RequestBody CredencialesDTO credenciales) {
        String email = credenciales.getEmail();
        String password = credenciales.getPassword();

        // Verificar que los campos no estén vacíos
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            return ResponseEntity.badRequest().body("El email y la contraseña son obligatorios");
        }

        // Buscar al cliente por email y contraseña
        Cliente cliente = service.findByEmailAndPassword(email, password);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos");
        }
    }

}
