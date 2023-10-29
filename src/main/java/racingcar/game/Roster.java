package racingcar.game;

import java.util.ArrayList;
import java.util.List;

public class Roster {
    private List<Car> roster = new ArrayList<>();
    private List<Car> winningCars = new ArrayList<>();
    private int longestCarRouteLength = 0;

    public Roster(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            roster.add(new Car(carName));
        }
    }

    public void moveAllCarsForward() {
        for (Car car : roster) {
            if (car.isMovable()) {
                car.moveForward();
            }
        }
    }

    public void updateLongestCarRoute() {
        for (Car car : roster) {
            String carRoute = car.getRoute();
            if (carRoute.length() > longestCarRouteLength) {
                longestCarRouteLength = carRoute.length();
            }
        }
    }

    public void determineWinningCars() {
        for (Car car : roster) {
            String carRoute = car.getRoute();
            if (carRoute.length() == longestCarRouteLength) {
                winningCars.add(car);
            }
        }
    }
}