package racingcar.repository;

import java.util.*;

import racingcar.domain.Racingcar;

public class MemoryRacingcarRepository implements RacingcarRepository {

    private Map<String, Racingcar> carStore = new HashMap<>();

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
    public ArrayList<Racingcar> findAll() {
        return new ArrayList<>(carStore.values());
    }

    public void possibleNameCheck(String name) {
        if (findByName(name) != null) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름입니다.");
        }
    }

    public void clear() {
        carStore.clear();
    }
}
