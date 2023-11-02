package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private final List<Car> racingCar = new ArrayList<>();
    private int maxDistance = 0;

    public RacingCar(List<String> carList) {
        for (String car : carList) {
            racingCar.add(new Car(car));
        }
    }

    public void saveMaxDistance() {
        for (Car car : racingCar) {
            if (car.getDistance() >= maxDistance) {
                maxDistance = car.getDistance();
            }
        }
    }

    public List<String> getWinnerList() {
        List<String> racingWinners = new ArrayList<>();
        saveMaxDistance();
        for (Car car : racingCar) {
            if (car.getDistance() == maxDistance) {
                racingWinners.add(car.getName());
            }
        }
        return racingWinners;
    }

    public List<Car> getRacingCar() {
        return racingCar;
    }

}