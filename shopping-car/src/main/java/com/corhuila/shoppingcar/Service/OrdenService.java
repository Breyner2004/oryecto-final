package com.corhuila.shoppingcar.Service;
import com.corhuila.shoppingcar.Document.HistorialOrden;
import com.corhuila.shoppingcar.Document.Producto;
import com.corhuila.shoppingcar.IRepository.IHistorialOrdenRepository;
import com.corhuila.shoppingcar.IRepository.IProductoRepository;
import com.corhuila.shoppingcar.IService.IOrdenService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
    public class OrdenService implements IOrdenService {

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private IHistorialOrdenRepository historialOrdenRepository;

    @Override
    @Transactional
    public void registrarOrden(List<Producto> productos) {
        for (Producto productoOrdenado : productos) {
            Producto producto = productoRepository.findById(productoOrdenado.getId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + productoOrdenado.getId()));
            if (producto.getStock() >= productoOrdenado.getStock()) {
                producto.setStock(producto.getStock() - productoOrdenado.getStock());
                productoRepository.save(producto);
            } else {
                throw new RuntimeException("Inventario insuficiente para el producto: " + productoOrdenado.getId());
            }
        }
        HistorialOrden historialOrden = new HistorialOrden();
        historialOrden.setProductos(productos);
        historialOrdenRepository.save(historialOrden);
    }

}
