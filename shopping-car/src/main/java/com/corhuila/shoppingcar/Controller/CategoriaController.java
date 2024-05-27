package com.corhuila.shoppingcar.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.corhuila.shoppingcar.Document.Categoria;
import com.corhuila.shoppingcar.IService.ICategoriaService;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "http://localhost:8100")
public class CategoriaController {
    
    private final ICategoriaService categoriaService;

    @Autowired
    public CategoriaController(ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaService.obtenerTodasLasCategorias();
    }

    @PostMapping
    public Categoria agregarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.agregarCategoria(categoria);
    }
}
