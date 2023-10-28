package racingcar.model;

import racingcar.constant.Rule;
import racingcar.model.car.Car;
import racingcar.validation.RacerValidator;
import racingcar.validation.Validator;

import java.util.Arrays;
import java.util.List;

public class Racer {

    private final List<Car> racer;

    public Racer(String value) {
        validate(value);
        this.racer = Arrays.stream(value.split(Rule.SEPARATOR))
                .map(Car::new)
                .toList();
    }

    //TODO: 욘석 여기 었어도 돼겠니??!
    //TODO: 메서드 이름이 move 괜찮겠냐? 고민해보자
    public void play() {
        racer.forEach(Car::move);
    }

    private void validate(String value) {
        Validator validator = new RacerValidator();
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
        List<Car> winner = getWinner();
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : winner) {
            stringBuilder.append(car.getName()).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
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
