package racingcar.model;

import java.text.MessageFormat;

public class RacingCar {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    private int lap;

    public RacingCar(String name) {
        validateName(name);

        this.name = name;
    }

    public void start() {

    }

    public boolean isSameLap(int lap) {
        return this.lap == lap;
    }

    public String getName() {
        return name;
    }

    public int getLap() {
        return lap;
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열이 될 수 없습니다.");
        }

        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(MessageFormat.format(
                    "자동차 이름은 {0}글자 이하만 가능합니다.", MAXIMUM_NAME_LENGTH));
        }
    }
}
