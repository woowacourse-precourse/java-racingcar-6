package racingcar.repository;

import java.util.List;
import java.util.Optional;
import racingcar.domain.IndexModel;

public interface Repository<T extends IndexModel> {
    T save(T object);
    Optional<T> findById(Long id);
    List<T> findAll();
    void deleteAll();
}