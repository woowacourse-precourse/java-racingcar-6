package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarRacing {
    private final List<Car> racingCars = new ArrayList<>();

    public CarRacing(List<String> racingCarNames) {
        setRacingCars(racingCarNames);
    }

    private void setRacingCars(List<String> racingCarsName) {
        for (String racingCarName : racingCarsName) {
            racingCars.add(new Car(racingCarName));
        }
    }

    public List<String> getWinners() {
        int maxMoveDistance = getMaxMoveDistance();
        List<String> winners = findWinners(maxMoveDistance);
        return winners;
    }

    private int getMaxMoveDistance() {
        return racingCars.stream()
                .mapToInt(Car::getMoveDistance)
                .max()
                .getAsInt();
    }

    private List<String> findWinners(int maxMoveDistance) {
        return racingCars.stream()
                .filter(racingCar -> racingCar.getMoveDistance() == maxMoveDistance)
                .map(Car::getName)
                .toList();
    }

    public void play() {
        for (Car racingCar : racingCars) {
            racingCar.move();
        }
    }

    public Map<String, Integer> makeResultMap() {
        ResultMap resultMap = new ResultMap(racingCars);
        return resultMap.getResultMap();
    }
}
