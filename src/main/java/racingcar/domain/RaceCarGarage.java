package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RaceCarGarage {

    private Map<String, Car> racingCars;

    public RaceCarGarage(List<String> racingCarNames) {
        readyRaceCar(racingCarNames);
    }

    private void readyRaceCar(List<String> racingCarNames) {
        this.racingCars = racingCarNames.stream()
                .collect(Collectors.toMap(
                        carName -> carName,
                        initCar -> new Car(),
                        (existing, replacement) -> existing,
                        LinkedHashMap::new));
    }

    public Map<String, Car> fitInRacingCars() {
        return racingCars;
    }


}
