package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.CarDTO;

public class CarManager {
    private final List<Car> cars = new ArrayList<>();

    public void createAndAddCars(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void tryToMoveCar(int CAR_AMOUNT) {
        for (int index = 0; index < CAR_AMOUNT; index++) {
            Car car = cars.get(index);
            car.tryMove();
        }

    }

    public List<CarDTO> getRoundResult() {
        List<CarDTO> roundResult = new ArrayList<>();
        for (Car car : cars) {
            roundResult.add(car.toDTO());
        }

        return roundResult;
    }

}
