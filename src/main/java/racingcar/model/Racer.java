package racingcar.model;

import racingcar.constant.Rule;
import racingcar.model.car.Car;
import racingcar.validation.Validator;
import racingcar.validation.ValidatorFactory;

import java.util.Arrays;
import java.util.List;

public class Racer {

    private final List<Car> racer;

    public Racer(String value) {
        validate(value);
        this.racer = Arrays.stream(value.split(Rule.NAME_SEPARATOR))
                .map(Car::new)
                .toList();
    }

    public void play() {
        racer.forEach(Car::move);
    }

    private void validate(String value) {
        ValidatorFactory validatorFactory = ValidatorFactory.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator(this.getClass());
        validator.validate(value);
    }

    private List<Car> getWinner() {
        Car first = racer.stream()
                .max(Car::compareTo)
                .orElseThrow(IllegalStateException::new);
        return racer.stream()
                .filter(car -> car.equals(first))
                .toList();
    }

    //TODO: 이 메서드 별로 안이쁨
    public String winnerToString() {
        List<String> winner = getWinner()
                .stream()
                .map(Car::getName)
                .toList();
        return String.join(Rule.NAME_SEPARATOR + " ", winner);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Racer target)) {
            return false;
        }
        return racer.equals(target.racer);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : racer) {
            stringBuilder.append(car.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
