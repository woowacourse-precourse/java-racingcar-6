package racingcar.domain.race.manager;

import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRacersRegistry {

    private final List<Car> racerList = new ArrayList<>();

    private CarRacersRegistry() {
    }

    public static CarRacersRegistry newInstance() {
        return new CarRacersRegistry();
    }

    public List<Car> getRacersList() {
        return new ArrayList<>(racerList);
    }

    public void registerRacer(final Car car) {
        racerList.add(car);
    }

}
