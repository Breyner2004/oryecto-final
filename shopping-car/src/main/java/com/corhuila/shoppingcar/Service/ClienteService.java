package com.corhuila.shoppingcar.Service;

import com.corhuila.shoppingcar.Document.Cliente;
import com.corhuila.shoppingcar.IRepository.IClienteRepository;
import com.corhuila.shoppingcar.IService.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository repository;

    @Override
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Cliente> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public void update(Cliente cliente, String id) {
        Optional<Cliente> optionalCliente = repository.findById(id);
        if (optionalCliente.isPresent()) {
            Cliente existingCliente = optionalCliente.get();
            existingCliente.setNombre(cliente.getNombre());
            existingCliente.setEmail(cliente.getEmail());
            existingCliente.setPassword(cliente.getPassword());
            repository.save(existingCliente);
        } else {
            System.out.println("No existe el cliente con ID: " + id);
        }
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public Cliente findByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }
}
