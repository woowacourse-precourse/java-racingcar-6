package racingcar;

import java.util.List;

public class Race {
    private List<Car> cars;

    public void play() {
        cars = getCars();
    }


    private List<Car> getCars() {
        return Car.getNames();
    }

}
