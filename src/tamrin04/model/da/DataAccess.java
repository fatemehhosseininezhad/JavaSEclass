package src.tamrin04.model.da;


import java.util.List;

public interface DataAccess<T > extends AutoCloseable {
        void save(T t) throws Exception;
        void edit(T t) throws Exception;
        void remove(int id) throws Exception;
        List<T> findAll() throws Exception;
        T findById(int id) throws Exception;
    }

