package racingcar.domain;

import racingcar.util.RandomNumberGenerator;
import racingcar.util.constant.ConstStandard;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final List<RacingCar> racingCars;

    public Race(List<String> carNames) {
        this.racingCars = new ArrayList<>();
        for (String carName : carNames) {
            this.racingCars.add(new RacingCar(carName));
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public Long getFarthestDistance() {
        Long farthestDistance = 0L;
        for (RacingCar car : racingCars) {
            if (car.getDistance() > farthestDistance) {
                farthestDistance = car.getDistance();
            }
        }
        return farthestDistance;
    }

    public void runCircuit() {
        for (RacingCar car : racingCars) {
            int movingValue = RandomNumberGenerator.generate();
            if (movingValue >= ConstStandard.CRITERIA_MOVE) {
                car.move();
            }
        }
    }
}
