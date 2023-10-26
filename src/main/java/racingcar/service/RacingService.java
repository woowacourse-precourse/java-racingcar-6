package racingcar.service;

import racingcar.domain.Garage;
import racingcar.util.RandomNumbersGenerator;

import java.util.List;

public class RacingService {

    public void race(Garage garage) {
        List<Integer> randomNumbers = RandomNumbersGenerator.generate(garage.getGarageSize());
        garage.moveCars(randomNumbers);
    }
}
