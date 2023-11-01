package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(){
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        Location maxLocation = findMaxLocation();

        for (Car car : cars) {
            if (car.isWinner(maxLocation)) {
                winners.add(car);
            }
        }

        return winners;
    }

    private Location findMaxLocation(){
        Location maxLocation = new Location();

        for (Car car : cars) {
            Location location = car.getLocation();
            if (location.isMax(maxLocation)) {
                maxLocation = location;
            }
        }

        return maxLocation;
    }

    public List<Car> getCars() {
        return cars;
    }
}
