package com.corhuila.shoppingcar.IRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.corhuila.shoppingcar.Document.Categoria;

public interface ICategoriaRepository extends MongoRepository<Categoria, String> {
    
}

