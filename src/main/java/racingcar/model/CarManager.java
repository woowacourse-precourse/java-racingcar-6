package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.config.Settings;
import racingcar.domain.Car;
import racingcar.dto.CarDTO;

public class CarManager {
    private final List<Car> cars = new ArrayList<>();

    public Car getCarFromIndex(int index) {
        Car car = cars.get(index);

        return car;
    }

    public int getFarthestPosition() {
        int number = findBiggestNumber();

        return number;
    }

    public void createAndAddCars(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
        Settings.setCarAmount(cars.size());
    }

    // Car의 DTO를 받아서 그 중 가장 큰 position의 값 반환
    private int findBiggestNumber() {
        int farthest = 0;
        for (Car car : cars) {
            CarDTO dto = car.toDTO();
            if (farthest < dto.getPosition()) {
                farthest = dto.getPosition();
            }
        }
        return farthest;
    }

}
