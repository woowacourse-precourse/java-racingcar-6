package racingcar.domain;

import racingcar.message.ExceptionMessage;
import racingcar.message.ProcessMessage;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

    private final NumberGenerator numberGenerator;
    private final String name;
    private int position;

    public Car(String name, NumberGenerator numberGenerator) {
        validateNameLength(name);
        this.name = name;
        this.position = 0;
        this.numberGenerator = numberGenerator;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.OVER_FIVE_LENGTH.toString());
        }
    }

    public void moveForward() {
        if (numberGenerator.generate()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String mapRecord() {
        String nameColon = String.format(ProcessMessage.RECORD.toString(), name);
        String hyphenRepeat = ProcessMessage.HYPHEN.toString().repeat(position);
        return nameColon + hyphenRepeat;
    }
}
