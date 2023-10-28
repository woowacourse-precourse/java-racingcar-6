package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Track;
import camp.nextstep.edu.missionutils.Randoms;

public class CarService {
    private static final int MOVE_THRESHOLD = 4;

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

    public void playRound() {
        for (Car car : track.getCars()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            moveCar(car, randomNumber);
        }
    }

    private void moveCar(Car car, int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            car.move();
        }
    }
}
