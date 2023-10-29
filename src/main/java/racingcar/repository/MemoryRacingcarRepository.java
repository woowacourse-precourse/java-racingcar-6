package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import racingcar.domain.Racingcar;

public class MemoryRacingcarRepository implements CarRepository{

    private static ArrayList<Racingcar> carStore = new ArrayList<>();

    @Override
    public Racingcar save(String name) {
        Racingcar racingCar = new Racingcar(name);
        carStore.add(racingCar);

        return racingCar;
    }

    @Override
    public Optional<Racingcar> findByName(String name) {
        return carStore.stream()
                .filter(racingcar -> racingcar.equals(racingcar.getName()))
                .findAny();
    }

    @Override
    public int update(String name, int distance) {
        Optional<Racingcar> racingCar = findByName(name);
        racingCar.get().setMovingforward(distance);

        return racingCar.get().getMovingforward();
    }

    @Override
    public List<Racingcar> findAll() {
        return new ArrayList<>(carStore);
    }
}
