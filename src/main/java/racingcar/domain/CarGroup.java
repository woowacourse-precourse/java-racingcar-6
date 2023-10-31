package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {

    private final List<Car> carGroup;

    private CarGroup(List<Car> carGroup) {
        this.carGroup = carGroup;
    }

    public boolean move() {
        for (Car car : carGroup) {
            car.move();
        }
        return true;
    }

    public List<String> getWinnerList() {
        return carGroup.stream()
            .filter(car -> car.getPosition() == getMaxPosition())
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return carGroup.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }

    public List<Car> getCars() {
        return carGroup;
    }

    public static CarGroup from(List<Car> carGroup) {
        return new CarGroup(carGroup);
    }

}
