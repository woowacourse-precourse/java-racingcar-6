package racingcar.repository;

import java.util.*;

import racingcar.domain.Racingcar;

public class MemoryRacingcarRepository implements CarRepository{

    private static Map<String, Racingcar> carStore = new HashMap<>();

    @Override
    public Racingcar save(String name) {
        Racingcar racingCar = new Racingcar(name);
        carStore.put(name, racingCar);

        return racingCar;
    }

    @Override
    public Racingcar findByName(String name) {
        return carStore.get(name);
    }

    @Override
    public int update(String name, int distance) {
        Racingcar racingcar = findByName(name);
        racingcar.setMovingforward(distance);

        return racingcar.getMovingforward();
    }

    @Override
    public List<Racingcar> findAll() {
        return new ArrayList<>(carStore.values());
    }
}
