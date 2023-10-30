package racingcar.repository;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Racingcar;

public interface CarRepository {

    Racingcar save(String name);

    Racingcar findByName(String name);

    ArrayList<Racingcar> findAll();
}
