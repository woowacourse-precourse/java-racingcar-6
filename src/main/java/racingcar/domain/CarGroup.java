package racingcar.domain;

import java.util.List;

public class CarGroup {

    private final List<Car> carGroup;

    private CarGroup(List<Car> carGroup) {
        this.carGroup = carGroup;
    }

    public static CarGroup from(List<Car> carGroup) {
        return new CarGroup(carGroup);
    }


    public int getMaxPosition() {
        return carGroup.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }

    public List<Car> getCars() {
        return carGroup;
    }
}
