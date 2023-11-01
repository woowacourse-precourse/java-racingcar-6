package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

public class RacingCarService {

    public RacingCars createRacingCars(List<String> racingCarNameList) {
        List<RacingCar> racingCars = new ArrayList<>();

        racingCarNameList.forEach(racingCarName -> {
            RacingCar racingCar = createRacingCar(racingCarName);
            racingCars.add(racingCar);
        });

        return new RacingCars(racingCars);
    }

    private RacingCar createRacingCar(String racingCarName) {
        return new RacingCar(racingCarName);
    }

}
