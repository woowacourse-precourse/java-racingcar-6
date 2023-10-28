package racingcar.model;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Stadium {
    private final int carCount;
    private final ArrayList<String> carNames;
    private ArrayList<Car> cars;

    public Stadium(ArrayList<String> carNames) {
        this.carNames = carNames;
        this.carCount = carNames.size();
        setStadium();
    }

    private void setStadium(){
        ArrayList<Car> parkingCars = new ArrayList<>();
        for (String carName : carNames) {
            parkingCars.add(new Car(carName));
        }
        this.cars = parkingCars;
    }

    public void go() {
        for (Car car : cars) {
            car.go();
        }
    }

    public String getProgress() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getTrace()).append("\n");
        }
        return sb.toString();
    }

    public String getWinners() {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }

}
