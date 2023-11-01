package racingcar.repository;

import racingcar.domain.RacingCar;

import java.util.*;

public class RacingCarRepository {
    private final Map<String, RacingCar> racingCarRepository = new HashMap<>();

    public RacingCar save(RacingCar car) {
        racingCarRepository.put(car.getCarName(), car);
        return car;
    }

    public List<RacingCar> findAll() {
        return racingCarRepository.values().stream().toList();
    }
}
