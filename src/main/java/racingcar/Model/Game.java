package racingcar.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    public List<Car> cars;
    public int stage;
    public RandomNumberGenerator randomNumberGenerator;
    public static int randomNumberCondition = 4;

    public Game(List<String> cars, int stage) {
        for (String carName : cars) {
            this.cars.add(new Car(carName));
        }
        if (!isValidateStageNumber(stage)) {
            throw new IllegalArgumentException();
        }
        this.stage = stage;
    }

    public Boolean isValidateStageNumber(int stageNumber) {
        return stage >= 0;
    }

    public Boolean isSatisfyForwardCondition(int randomNumber) {
        return randomNumber >= randomNumberCondition;
    }

    public Boolean isGameEnd() {
        return stage == 0;
    }

    public void decideCarMoving(Car car) {
        int result = randomNumberGenerator.getRandomNumberResult();
        if (isSatisfyForwardCondition(result)) {
            car.goStraight(result);
        }
    }

    public Map<String, Integer> runStage() {
        Map<String, Integer> result = new HashMap<>();
        for (Car car : cars) {
            decideCarMoving(car);
            result.put(car.getCarName(), car.getCurrentLocation());
        }
        stage -= 1;
        return result;
    }

    public List<String> findWinner() {
        int maxStep = cars.stream().mapToInt(Car::getCurrentLocation).max().orElse(0);
        return cars.stream().filter(car -> car.getCurrentLocation() == maxStep).map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
