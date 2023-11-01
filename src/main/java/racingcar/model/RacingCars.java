package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<Car> cars = new ArrayList<>();

    private final List<String> winners = new ArrayList<>();


    public RacingCars() {}


    public void setCars(List<String> names) {
        for(String name : names)
            cars.add(new Car(name));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setWinners(List<String> names) {
        for(String name : names)
            winners.add(name);
    }

    public List<String> getWinners() {
        return winners;
    }

}
