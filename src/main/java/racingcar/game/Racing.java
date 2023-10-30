package racingcar.game;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> racingCars = new ArrayList<>();
    private List<Car> winningCars = new ArrayList<>();
    private int longestCarRouteLength = 0;

    public Racing(String carNames) {
        for (String carName : carNames.split(",")) {
            racingCars.add(new Car(carName));
        }
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public List<Car> getWinningCars() {
        return winningCars;
    }

    public void moveAllCarsForward() {
        for (Car car : racingCars) {
            if (car.isMovable()) {
                car.moveForward();
            }
        }
    }

    public void updateLongestCarRoute() {
        for (Car car : racingCars) {
            String carRoute = car.getRoute();
            if (carRoute.length() > longestCarRouteLength) {
                longestCarRouteLength = carRoute.length();
            }
        }
    }

    public void determineWinningCars() {
        for (Car car : racingCars) {
            String carRoute = car.getRoute();
            if (carRoute.length() == longestCarRouteLength) {
                winningCars.add(car);
            }
        }
    }
}