package racingcar.domain;

import racingcar.message.ExceptionMessage;
import racingcar.message.ProcessMessage;

import java.util.List;

public class Cars {
    private final List<Car> values;

    public Cars(List<Car> values) {
        validateIsDuplicate(values);
        this.values = values;
    }

    private void validateIsDuplicate(List<Car> values) {
        if(values.size() != values.stream().map(Car::getName).distinct().count()){
            throw new IllegalArgumentException(ExceptionMessage.IS_DUPLICATE.toString());
        }
    }

    public void moveForward() {
        values.forEach(Car::moveForward);
    }

    public String getMoveRecord() {
        StringBuilder sb = new StringBuilder();
        values.forEach(car -> sb.append(car.mapRecord()).append(ProcessMessage.NEW_LINE));
        return sb.toString();
    }

    public Winners getWinners() {
        int max = values.stream()
                .mapToInt(Car::getPosition)
                .max().getAsInt();
        return new Winners(values.stream().filter(car -> car.getPosition() >= max).toList());
    }
}
