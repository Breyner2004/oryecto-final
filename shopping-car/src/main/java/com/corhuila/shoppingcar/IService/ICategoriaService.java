package com.corhuila.shoppingcar.IService;
import java.util.List;
import com.corhuila.shoppingcar.Document.Categoria;


public interface ICategoriaService {
    List<Categoria> obtenerTodasLasCategorias();
    Categoria agregarCategoria(Categoria categoria);
}