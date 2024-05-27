package com.corhuila.shoppingcar.IRepository;
import com.corhuila.shoppingcar.Document.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository
public interface IProductoRepository extends MongoRepository<Producto, String> {
    List<Producto> findByCategoriaId(String categoriaId);

}
