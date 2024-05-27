package com.corhuila.shoppingcar.Controller;

import com.corhuila.shoppingcar.Document.Producto;
import com.corhuila.shoppingcar.IService.IOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    private final IOrdenService ordenService;

    @Autowired
    public OrdenController(IOrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @PostMapping
    public ResponseEntity<String> registrarOrden(@RequestBody List<Producto> productos) {
        try {
            ordenService.registrarOrden(productos);
            return ResponseEntity.ok("Orden registrada exitosamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
