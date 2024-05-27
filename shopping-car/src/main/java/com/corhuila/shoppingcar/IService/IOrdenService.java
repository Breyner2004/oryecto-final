package com.corhuila.shoppingcar.IService;
import com.corhuila.shoppingcar.Document.Producto;
import java.util.List;
import com.corhuila.shoppingcar.Document.HistorialOrden;

public interface IOrdenService {
    void registrarOrden(List<Producto> productos);


}