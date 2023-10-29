package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.handler.ErrorHandler.MAX_VALUE_MISSING;

public class CarStatusGroup {

    private final List<CarStatus> carStatusList;

    private CarStatusGroup(List<CarStatus> carStatusList) {
        this.carStatusList = carStatusList;
    }

    public static CarStatusGroup create(List<CarStatus> carStatusList) {
        return new CarStatusGroup(carStatusList);
    }

    public void moveForward() {
        for (CarStatus carStatus : carStatusList) {
            RandomNumber randomNumber = RandomNumber.create();
            carStatus.forWard(randomNumber.getRandomNumber());
        }
    }

    public CarStatus getMaxPosition() {
        return carStatusList.stream()
                .max(CarStatus::compareTo)
                .orElseThrow(() -> MAX_VALUE_MISSING.getException());
    }

    public List<String> getWinnerNames(CarStatus maxPositionCar) {
        return carStatusList.stream()
                .filter(maxPositionCar::isSamePosition)
                .map(CarStatus::getCarName)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<CarStatus> getCarStatusList() {
        return List.copyOf(carStatusList);
    }
}
