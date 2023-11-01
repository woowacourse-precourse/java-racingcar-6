package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Race {
    private final List<Car> cars;

    public Race(String carNames) {
        this.cars = initializeCars(carNames.split(","));
    }

    private List<Car> initializeCars(String[] names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
        return carList;
    }

    public void run() {
        cars.forEach(car -> car.move(pickNumberInRange(0, 9)));
    }

    public List<Car> getCars() {
        return cars;
    }
}


