package Dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    List<T> findAll();

    void create(T t);

//    Optional<T> findById(int id);

    void update(T t);

    void deleteById(int id);

}
