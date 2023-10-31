package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.model.dto.CarDto;
import racingcar.model.number.NumberGenerator;

public class RacingCars {
    private final List<Car> cars;

    private RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingCars createCars(String[] names) {
        List<Car> carNames = new ArrayList<>();
        for (String name : names) {
            carNames.add(Car.createCar(trimName(name)));
        }
        return new RacingCars(Collections.unmodifiableList(carNames));
    }

    public void move(NumberGenerator generator) {
        cars.forEach(car -> car.moveForward(generator));
    }

    public List<CarDto> getStatus() {
        ArrayList<CarDto> carsDto = new ArrayList<>();
        for (Car car : cars) {
            carsDto.add(new CarDto(car.getName(), car.getPosition()));
        }
        return Collections.unmodifiableList(carsDto);
    }

    public int getMaxPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return Collections.max(positions);
    }

    private static String trimName(String name) {
        return name.trim();
    }
}