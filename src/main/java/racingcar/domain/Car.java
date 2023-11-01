package racingcar.domain;

import static racingcar.exception.CarNameException.*;

public class Car {
    private final static int CAR_MOVABLE_MIN_NUMBER = 4;
    private final static String NAME_FORMAT = "%s : ";
    private final static String DASH = "-";
    private final String name;

    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateCarNameLength(name);
        validateCarNameBlank(name);
        validateCarNameEmpty(name);
        validateCarNameEng(name);
    }

    public void move(NumberGenerator numberGenerator) {
        final int number = numberGenerator.generate();

        if (number >= CAR_MOVABLE_MIN_NUMBER) {
            position++;
        }
    }

    public String getCurState() {
        StringBuilder stringBuilder = new StringBuilder(String.format(NAME_FORMAT, name));
        for (int i = 0; i < position; i++) {
            stringBuilder.append(DASH);
        }
        return stringBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    protected boolean isSamePosition(int maxPosition) {
        if (this.position == maxPosition) {
            return true;
        }
        return false;
    }
}
