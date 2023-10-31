package racingcar.repository;

import java.util.ArrayList;

import racingcar.domain.Racingcar;

public interface RacingcarRepository {

    Racingcar save(String name);

    Racingcar findByName(String name);

    ArrayList<Racingcar> findAll();

    void clear();
}
