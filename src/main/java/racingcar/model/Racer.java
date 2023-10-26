package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class Racer {

    private static final String SEPARATOR = ",";
    private final List<Car> racer;

    public Racer(String value) {
        validate(value);
        this.racer = Arrays.stream(value.split(SEPARATOR))
                .map(Car::new)
                .toList();
    }

    //TODO: 욘석 여기 었어도 돼겠니??!
    //TODO: 메서드 이름이 move 괜찮겠냐? 고민해보자
    public void play() {
        racer.forEach(Car::move);
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

    private void validate(String value) {
        validateSize(value);
    }

    private void validateSize(String value) {
        if (value == null || value.split(SEPARATOR).length == 0) {
            throw new IllegalArgumentException("참가자가 없습니다.");
        }
    }
}
