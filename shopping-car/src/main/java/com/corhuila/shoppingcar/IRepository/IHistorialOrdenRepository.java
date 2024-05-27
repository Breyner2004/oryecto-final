package com.corhuila.shoppingcar.IRepository;
import com.corhuila.shoppingcar.Document.HistorialOrden;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHistorialOrdenRepository extends MongoRepository<HistorialOrden, String> {
}