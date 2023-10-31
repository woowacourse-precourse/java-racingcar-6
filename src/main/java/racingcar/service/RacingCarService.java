package racingcar.service;

import racingcar.model.Car;
import racingcar.model.RacingCarGame;
import racingcar.util.RandomUtil;
import racingcar.util.SeparationUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCarService {

    private static final int MIN_VALUE = -1;

    private final RacingCarGame racingCarGame = new RacingCarGame();

    private final ValidateService validateService = new ValidateService();

    List<Car> cars = new ArrayList<>();

    public void createCar(String carNames) {
        validateService.validateInputCarName(carNames);
        List<String> separatedCarNames = separateCarName(carNames);

        for (String separatedCarName : separatedCarNames) {
            Car car = new Car();
            car.initCar(separatedCarName);
            cars.add(car);
        }
    }

    public int getCount() {
        return racingCarGame.getCount();
    }

    public void setCount(String inputNumber) {
        racingCarGame.setCount(parseStringToInt(inputNumber));
    }

    private int parseStringToInt(String inputNumber) {
        return Integer.parseInt(inputNumber);
    }

    private List<String> separateCarName(String carNames) {
        return SeparationUtil.separationCarName(carNames);
    }

    public void gameProcess() {
        for (Car car : cars) {
            setRandomNumberToCar(car);
            compareNumber(car);
        }
        roundEnd();
    }

    public Map<String, Integer> currentSituation() {
        Map<String, Integer> situations = new HashMap<>();

        for (Car car : cars) {
            situations.put(car.getName(), car.getDistance());
        }
        return situations;
    }

    public List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();
        cars.forEach(car -> carNames.add(car.getName()));
        return carNames;
    }

    private void setRandomNumberToCar(Car car) {
        car.setCarRandomNumber(RandomUtil.createRandomNumber());
    }

    private void compareNumber(Car car) {
        if (car.getRandomNumber() >= 4) {
            car.addOneDistance();
        }
    }

    private void roundEnd() {
        racingCarGame.minusOneCount();
    }

    public List<String> getWinners() {
        int maxDistance = getMaxDistance();
        return getWinnerCarsName(maxDistance);
    }

    private List<String> getWinnerCarsName(int maxDistance) {
        return cars.stream().filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();
    }

    private int getMaxDistance() {
        int max = MIN_VALUE;

        for (Car car : cars) {
            if (max < car.getDistance()) max = car.getDistance();
        }

        return max;
    }
}
