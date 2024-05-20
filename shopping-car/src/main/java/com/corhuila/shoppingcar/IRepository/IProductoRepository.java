package com.corhuila.shoppingcar.IRepository;

import com.corhuila.shoppingcar.Document.Producto;
import com.corhuila.shoppingcar.Document.Proveedor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends MongoRepository<Producto, String> {

}
