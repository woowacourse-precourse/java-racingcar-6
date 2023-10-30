package racingcar.repository;

import racingcar.domain.Racer;

import java.util.Optional;

public interface RacerRepository {
    public Racer save(Racer racer);
    public Optional<Racer> findById(Long id);
    public Optional<Racer> findByName(String name);
    public int getMoving(String name);
}
