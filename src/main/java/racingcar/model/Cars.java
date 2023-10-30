package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars createCars(String[] names) {
        List<Car> carNames = new ArrayList<>();
        for (String name : names) {
            carNames.add(Car.createCar(trimName(name)));
        }
        return new Cars(Collections.unmodifiableList(carNames));
    }

    public void move() {
        carList.forEach(Car::moveForward);
    }

    public List<CarDto> getStatus() {
        ArrayList<CarDto> carsDto = new ArrayList<>();
        for (Car car : carList) {
            carsDto.add(new CarDto(car.getName(), car.getPosition()));
        }
        return Collections.unmodifiableList(carsDto);
    }

    private static String trimName(String name) {
        return name.trim();
    }
}