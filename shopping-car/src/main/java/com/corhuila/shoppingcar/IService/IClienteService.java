package com.corhuila.shoppingcar.IService;

import com.corhuila.shoppingcar.Document.Cliente;
import java.util.List;
import java.util.Optional;

public interface IClienteService {
    List<Cliente> findAll();
    Optional<Cliente> findById(String id);
    Cliente save(Cliente cliente);
    void update(Cliente cliente, String id);
    void delete(String id);
    Cliente findByEmailAndPassword(String email, String password);
}