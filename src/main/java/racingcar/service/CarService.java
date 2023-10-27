package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Track;

public class CarService {
    private final Track track = new Track(new ArrayList<>());

    public void createCars(String carNames) {
        for (String carName : splitNames(carNames)) {
            track.addCar(new Car(carName, 0));
        }
    }

    private List<String> splitNames(String carNames) {
        return List.of(carNames.split(","));
    }

    public List<Car> getAllCars() {
        return track.getCars();
    }
}
