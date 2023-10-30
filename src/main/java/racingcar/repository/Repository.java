package racingcar.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    T save(T object);
    Optional<T> findById(Long id);
    List<T> findAll();
    void deleteAll();
}
