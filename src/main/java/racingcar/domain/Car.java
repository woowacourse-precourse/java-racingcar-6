package racingcar.domain;

import racingcar.view.InputView;

public class Car {

    private final String carName;

    private int position;

    public Car(String carName) {
        isCarNameLengthOver(carName);
        isNotAlphaBetAndComma(carName);
        isCarNameBlank(carName);
        isCarNameNull(carName);
        this.carName = carName;
        this.position = 0;
    }

    public void move() {
        this.position++;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    private void isCarNameLengthOver(String input) {

        if (input.length() > InputView.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void isNotAlphaBetAndComma(String carName) {

        if (!carName.matches("[a-z]+")) {
            throw new IllegalArgumentException("");
        }
    }

    private void isCarNameBlank(String input) {

        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void isCarNameNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
    }
}
