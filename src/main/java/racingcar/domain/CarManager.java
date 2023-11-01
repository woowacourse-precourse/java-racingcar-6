package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CarManager {
    static HashMap<String, Integer> carScore = new HashMap<>();
    private static List<Car> cars = new ArrayList<>();

    public List<Car> initCar(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public HashMap<String, Integer> midtermScoreData() {
        for (Car carName : cars) {
            carScore.put(carName.getCarName(), carName.getDistance());
        }

        return carScore;
    }

    public List<String> finalScoreData() {
        int topDistance = findTopScore(cars);

        List<String> winnerList = cars.stream()
                .filter(car -> car.getDistance() == topDistance)
                .map(Car::getCarName)
                .collect(Collectors.toList());

        return winnerList;
    }

    private int findTopScore(List<Car> carNames) {

        return carNames.stream()
                .mapToInt(Car::getDistance) //=(Car car) -> car.getDistance()
                .max()
                .orElse(0);
    }

    public void setCarRandomNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        for (Car carName : cars) {
            if (randomNumberGenerator.isNumberThanEqualFour()) {
                carName.move();
            }
        }
    }

}
