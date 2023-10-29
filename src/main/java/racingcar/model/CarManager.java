package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.config.Settings;
import racingcar.domain.Car;
import racingcar.dto.CarDTO;

public class CarManager {
    private List<Car> cars = new ArrayList<>();

    public Car getCarFromIndex(int index) {
        return cars.get(index);
    }

    public int getFarthestMove() {
        int farthest = 0;
        for (Car car : cars) {
            CarDTO dto = car.toDTO();
            if (farthest < dto.getPosition()) {
                farthest = dto.getPosition();
            }
        }

        return farthest;
    }

    public void createAndAddCars(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
        Settings.setCarAmount(cars.size());
    }

}
