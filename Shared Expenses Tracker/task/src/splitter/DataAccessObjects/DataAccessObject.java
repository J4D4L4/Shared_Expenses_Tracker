package splitter.DataAccessObjects;

import java.util.List;
public interface DataAccessObject<T> {

    T get(long id);
    List<T> getAll();
    void create(T t);
    void update(T t, String[] params);
    void delete(T t);

}
