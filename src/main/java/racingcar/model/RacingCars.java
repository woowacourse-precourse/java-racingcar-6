package racingcar.model;

import java.util.List;

public class RacingCars {

    private static final int FORWARD_JUDGE_NUMBER = 4;

    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public void generateRacingCars(String inputCarName) {
        for (String carName : inputCarName.split(",")) {
            Car generatedCar = new Car(carName);
            racingCars.add(generatedCar);
        }
    }

    public void forwardJudge() {
        for (Car racingCar  : racingCars) {
            int randomNumber = GenerateRandomNumber.generate();
            if (randomNumber >= FORWARD_JUDGE_NUMBER) {
                racingCar.goForward();
            }
        }
    }
}
