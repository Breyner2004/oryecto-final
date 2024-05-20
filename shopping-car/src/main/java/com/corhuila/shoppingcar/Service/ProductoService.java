package com.corhuila.shoppingcar.Service;

import com.corhuila.shoppingcar.Document.Producto;
import com.corhuila.shoppingcar.IRepository.IProductoRepository;
import com.corhuila.shoppingcar.IService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    //Conectar con los datos - IRepository
    // Inyección de dependencia
    @Autowired
    private IProductoRepository repository;

    @Override
    public List<Producto> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Producto> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public void update(Producto producto, String id) {
        Optional<Producto> optionalProducto = repository.findById(id);
        if (optionalProducto.isPresent()) {
            Producto productoToUpdate = optionalProducto.get();
            productoToUpdate.setCodigo(producto.getCodigo());
            productoToUpdate.setNombre(producto.getNombre());
            productoToUpdate.setPrecio(producto.getPrecio());
            productoToUpdate.setStock(producto.getStock());
            productoToUpdate.setMarca(producto.getMarca());
            repository.save(productoToUpdate);
        } else {
            System.out.println("No existe el producto");
        }
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
