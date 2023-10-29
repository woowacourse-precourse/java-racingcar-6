package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public List<Map<String, String>> getRacingCarsInfo() {
        List<Map<String, String>> racingCarsInfo = new ArrayList<>();
        List<Car> racingCarsList = racingCars;

        for (Car racingCar : racingCarsList) {
            Map<String, String> carInfo = racingCar.getCarInfo();
            racingCarsInfo.add(carInfo);
        }
        return racingCarsInfo;
    }
}
