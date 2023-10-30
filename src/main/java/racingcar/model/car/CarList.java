package racingcar.model.car;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.manager.CarMoveManager;
import racingcar.util.CarNameValidator;
import racingcar.util.RandomNumberGenerator;

public class CarList {
    private final List<Car> carList;

    public CarList(List<Car> carList) {
        validate(carList);
        this.carList = carList;
    }

    private void validate(List<Car> carList) {
        List<String> carNames = carList.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
        CarNameValidator.validate(carNames);
    }

    public void moveAllCarListOnce(CarMoveManager carMoveManager) {
        carList.forEach(car -> car.move(carMoveManager.isMove(RandomNumberGenerator.getRandomNumber())));
    }

    public List<Car> getCurrentResult() {
        return List.copyOf(carList);
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return carList.stream()
                .filter(car -> car.isSame(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

}
