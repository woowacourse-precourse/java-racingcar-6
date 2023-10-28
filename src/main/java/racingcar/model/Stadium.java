package racingcar.model;

import java.util.ArrayList;

public class Stadium {
    private final ArrayList<String> carNames;
    private ArrayList<Car> cars;

    public Stadium(ArrayList<String> carNames) {
        this.carNames = carNames;
    }

    public void setStadium(){
        ArrayList<Car> parkingCars = new ArrayList<>();
        for (String carName : carNames) {
            parkingCars.add(new Car(carName));
        }
        this.cars = parkingCars;
    }

    public void raceOnce() {
        for (Car car : cars) {
            car.drive();
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

}
