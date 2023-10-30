package racingcar.repository;

import java.util.List;

import racingcar.domain.Racingcar;

public interface CarRepository {

    Racingcar save(String name);

    Racingcar findByName(String name);
    int update(String name, int distance);

    List<Racingcar> findAll();
}
