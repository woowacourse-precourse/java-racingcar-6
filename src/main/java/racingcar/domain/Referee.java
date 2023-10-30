package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    private final static int MINIMUM_MOVE_NUM = 4;
    private final RandomNumberGenerator randomNumberGenerator;

    public Referee(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void playRound(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            if (randomNumberGenerator.generate(0, 9) >= MINIMUM_MOVE_NUM) {
                car.move();
            }
        }
    }

    public List<RacingCar> getWinners(List<RacingCar> racingCars) {
        int maxDistance = Integer.MIN_VALUE;
        List<RacingCar> winners = new ArrayList<>();
        for (RacingCar car : racingCars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
                winners.clear();
                winners.add(car);
            } else if (car.getDistance() == maxDistance) {
                winners.add(car);
            }
        }
        return winners;
    }
}
