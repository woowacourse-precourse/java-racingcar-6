package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingCars {

    private static final int FORWARD_JUDGE_NUMBER = 4;
    private int firstPosition = -1;    // 아무도 전진을 못한 경우를 생각해 -1로 세팅

    private final List<Car> racingCars;

    public List<Car> getRacingCars() {
        return racingCars;
    }

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
        for (Car racingCar : racingCars) {
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

    public void getFirstPosition() {
        for (Car racingCar : racingCars) {
            Map<String, String> carInfos = racingCar.getCarInfo();
            int carPosition = carInfos.get("position").length();
            if (carPosition > firstPosition) {
                firstPosition = carPosition;
            }
        }
    }

    public List<String> winnersJudge() {
        getFirstPosition();
        return racingCars.stream()
                .filter(racingCar -> {
                    int position = racingCar.getCarInfo().get("position").length();
                    return position == firstPosition;
                })
                .map(racingCar -> racingCar.getCarInfo().get("name"))
                .collect(Collectors.toList());
    }
}
