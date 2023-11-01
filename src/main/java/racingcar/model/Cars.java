package racingcar.model;

import racingcar.utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> carList;
    private  StringBuilder stringBuilder;

    public Cars() {
        this.stringBuilder = new StringBuilder();
    }

    public List<Car> createCars(List<String> carNames) {
        carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return carList;
    }

    public StringBuilder roundCarResult() {
        stringBuilder.setLength(0);
        for (Car car : carList) {
            stringBuilder.append("\n").append(eachCarResult(car));
        }
        return stringBuilder;
    }

    private String eachCarResult(Car car) {
        car.forwardPosition(RandomUtils.generateRandomNumber());
        return car.getCurrentResultPosition();
    }

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

}
