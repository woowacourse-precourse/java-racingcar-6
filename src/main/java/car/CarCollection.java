package car;

import java.util.ArrayList;
import java.util.List;

public class CarCollection {

    private final List<Car> cars;

    public CarCollection() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void moveCarsForward() {
        for (Car car : cars) {
            car.movingForward();
        }
    }

    public void printCarsDistance() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxDistance = getMaxDistance();
        for (Car car : cars) {
            if (car.getDistance() >= maxDistance) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
