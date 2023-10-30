package racingcar.repository;

import java.util.ArrayList;

import racingcar.domain.Racingcar;

public interface RacingCarRepository {

    Racingcar save(String name);

    Racingcar findByName(String name);

    ArrayList<Racingcar> findAll();

    void possibleNameCheck(String name);

    void clear();
}
