package com.corhuila.shoppingcar.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corhuila.shoppingcar.IRepository.ICategoriaRepository;
import com.corhuila.shoppingcar.Document.Categoria;
import com.corhuila.shoppingcar.IService.ICategoriaService;

import java.util.List;
@Service
public class CategoriaService  implements ICategoriaService {

    @Autowired
    private ICategoriaRepository repository;

    @Override
    public List<Categoria> obtenerTodasLasCategorias() {
        return repository.findAll();
    }

    @Override
    public Categoria agregarCategoria(Categoria categoria) {
        return repository.save(categoria);
    }

    
}
