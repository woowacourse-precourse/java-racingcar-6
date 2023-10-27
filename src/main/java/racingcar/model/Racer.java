package racingcar.model;

import racingcar.constant.Rule;
import racingcar.validation.RacerValidator;
import racingcar.validation.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    //TODO: 이 메서드 별로 안이쁨
    public String getWinner() {
        Car winner = racer.stream().max(Car::compareTo).orElseThrow();
        return racer.stream().filter(winner::equals)
                .map(Car::getName)
                .collect(Collectors.joining(Rule.SEPARATOR));
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
