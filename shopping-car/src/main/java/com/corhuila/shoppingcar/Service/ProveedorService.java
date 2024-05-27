package com.corhuila.shoppingcar.Service;

import com.corhuila.shoppingcar.Document.Proveedor;
import com.corhuila.shoppingcar.IRepository.IProveedorRepository;
import com.corhuila.shoppingcar.IService.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
 public class ProveedorService implements IProveedorService {
    @Autowired
    private IProveedorRepository repository;

    @Override
    public List<Proveedor> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Proveedor> findById(Long id) {
        return repository.findById(String.valueOf(id));
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return repository.save(proveedor);
    }

    @Override
    public void update(Proveedor proveedor, Long id) {
        Optional<Proveedor> optionalProveedor = repository.findById(String.valueOf(id));
        if (optionalProveedor.isPresent()) {
            Proveedor proveedorToUpdate = optionalProveedor.get();
            proveedorToUpdate.setCodigo(proveedor.getCodigo());
            proveedorToUpdate.setNombre(proveedor.getNombre());
        
            repository.save(proveedorToUpdate);
        } else {
            System.out.println("No existe el proveedor");
        }
    }
    @Override
    public void delete(Long id) {
        repository.deleteById(String.valueOf(id));
    }
}
