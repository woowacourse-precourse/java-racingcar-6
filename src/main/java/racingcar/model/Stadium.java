package racingcar.model;

import java.util.ArrayList;

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

    public String getProgress() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getTrace()).append("\n");
        }
        return sb.toString();
    }

    public String getWinners() {
        int maxDistance = 0;
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
                sb.setLength(0);
                sb.append(car.getCarName());
            }
            if (car.getDistance() == maxDistance) {
                sb.append(", ").append(car.getCarName());
            }
        }
        return sb.toString();
    }

}
