package racingcar.service;

import racingcar.model.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarService {
    private static final String DELIMITER = ",";
    private List<RacingCar> racingCars;

    public RacingCarService() {
        racingCars = new ArrayList<>();
    }

    public String[] splitRacingCarsByComma(String racingCars) {
        return racingCars.split(DELIMITER);
    }

    public void saveRacingCars(String[] carNames) {
        racingCars = Arrays.stream(carNames)
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

}
