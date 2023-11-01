package racingcar.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import racingcar.domain.IndexModel;

/**
 * 순차적인 index를 가지는 방식으로 저장되는 저장소를 위해 필수적인 기능을 구현해놓은 추상 클래스입니다.
 */
public abstract class MemoryRepository<T extends IndexModel> implements Repository {

    protected Map<Long, T> store = new HashMap<>();
    protected Long sequence;

    public MemoryRepository() {
        resetSequence();
    }

    private void resetSequence() {
        sequence = 0L;
    }

    @Override
    public T save(IndexModel object) {
        store.put(++sequence, (T) object);
        object.setId(sequence);
        return (T) object;
    }

    @Override
    public Optional<T> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void deleteAll() {
        store.clear();
        resetSequence();
    }
}
