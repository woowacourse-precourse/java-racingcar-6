package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Stadium {
    private final ArrayList<String> carNames;
    private final ArrayList<Car> cars;

    public Stadium(ArrayList<String> carNames) {
        checkDuplicates(carNames);
        this.carNames = carNames;
        this.cars = setStadium();
    }

    private ArrayList<Car> setStadium(){
        ArrayList<Car> parkingCars = new ArrayList<>();
        for (String carName : carNames) {
            parkingCars.add(new Car(carName));
        }
        return parkingCars;
    }

    public void raceOnce() {
        for (Car car : cars) {
            car.drive();
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    private void checkDuplicates(ArrayList<String> carNames) {
        Set<String> check = new HashSet<>(carNames);
        if (check.size() != carNames.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

}
