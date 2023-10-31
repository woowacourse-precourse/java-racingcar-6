package racingcar.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.Global.Constants;

public class Game {
    public List<Car> cars;
    public int remainStage;
    public RandomNumberGenerator randomNumberGenerator;


    public Game(List<Car> cars, RandomNumberGenerator randomNumberGenerator, int remainStage) {
        this.cars = cars;
        this.randomNumberGenerator = randomNumberGenerator;
        if (!isValidateStageNumber(remainStage)) {
            throw new IllegalArgumentException();
        }
        this.remainStage = remainStage;
    }

    private Boolean isValidateStageNumber(int stageNumber) {
        return stageNumber >= 0;
    }

    private Boolean isSatisfyForwardCondition(int randomNumber) {
        return randomNumber >= Constants.randomNumberCondition;
    }

    public Boolean isGameEnd() {
        return remainStage == 0;
    }

    private void decideCarMoving(Car car) {
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
        remainStage -= 1;
        return result;
    }

    public List<String> findWinner() {
        int maxStep = cars.stream().mapToInt(Car::getCurrentLocation).max().orElse(0);
        return cars.stream().filter(car -> car.getCurrentLocation() == maxStep).map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
