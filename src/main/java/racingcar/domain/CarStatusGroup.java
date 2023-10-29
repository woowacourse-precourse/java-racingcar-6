package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.handler.ErrorHandler.MAX_VALUE_MISSING;

public class CarStatusGroup {

    private final List<CarStatus> carStatusList;

    public CarStatusGroup(List<CarStatus> carStatusList) {
        this.carStatusList = carStatusList;
    }

    public void moveForward() {
        for (CarStatus carStatus : carStatusList) {
            RandomNumber randomNumber = new RandomNumber();

            if (randomNumber.isMovePossible()) {
                carStatus.forWard();
            }
        }
    }

    public List<CarStatus> getFinishCarList() {
        return List.copyOf(carStatusList);
    }

    public List<String> getWinnerNames(CarStatus maxPositionCar) {
        return carStatusList.stream()
                .filter(maxPositionCar::isSamePosition)
                .map(CarStatus::getCarName)
                .collect(Collectors.toUnmodifiableList());
    }

    public CarStatus getMaxPosition() {
        return carStatusList.stream()
                .max(CarStatus::compareTo)
                .orElseThrow(() -> MAX_VALUE_MISSING.getException());
    }
}
