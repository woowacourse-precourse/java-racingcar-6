package racingcar.repository;

import racingcar.domain.Racer;

import java.util.List;
import java.util.Optional;

public interface RacerRepository {
    public Racer save(Racer racer);
    public Optional<Racer> findById(Long id);
    public Optional<Racer> findByName(String name);
    public void setMoveByName(String name);
    public int getMoveByName(String name);
    public List<Racer> findAll();
}
