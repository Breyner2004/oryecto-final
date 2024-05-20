package com.corhuila.shoppingcar.Controller;


import com.corhuila.shoppingcar.Document.Proveedor;
import com.corhuila.shoppingcar.IService.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/proveedor")

public class ProveedorController {
    @Autowired
    private IProveedorService proveedorService;

    @GetMapping()
    public List<Proveedor> findAll() {
        return proveedorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Proveedor> findById(@PathVariable Long id) {
        return proveedorService.findById(id);
    }

    @PostMapping()
    public Proveedor save(@RequestBody Proveedor proveedor) {
        return proveedorService.save(proveedor);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Proveedor proveedor, @PathVariable Long id) {
        proveedorService.update(proveedor, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        proveedorService.delete(id);
    }

}

