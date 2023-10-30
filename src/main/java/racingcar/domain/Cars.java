package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Converter;
import racingcar.Utils;

public record Cars(List<Car> carList) {
    public static final String CAR_NAME_DELIMITER = ",";

    public static Cars createByString(String carsString) {
        List<Car> carList = Converter.splitByDelimiter(carsString, CAR_NAME_DELIMITER)
                .stream()
                .map(CarName::new)
                .map(carName -> new Car(carName, new Position(0)))
                .toList();
        return new Cars(carList);
    }

    public void moveRandomly() {
        carList.forEach(car -> {
            if (Utils.isTrueWithProbability60Percent()) {
                car.moveForward();
        }});
    }

    public List<Car> getWinnerList() {
        Integer winnerPosition = getWinnerPosition();
        return carList.stream()
                .filter(car -> car.isSamePosition(winnerPosition))
                .collect(Collectors.toList());
    }

    private Integer getWinnerPosition() {
        return carList.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }

    @Override
    public String toString() {
        return carList.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }
}
