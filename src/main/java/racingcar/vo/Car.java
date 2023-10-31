package racingcar.vo;

import racingcar.exception.RacingCarError;

public class Car {

    private String name;

    private final StringBuilder position = new StringBuilder();

    public Integer getPositionLength() {
        return position.length();
    }
    public Car(String name) {
        validCarName(name);
        this.name = name;

    }

    private void validCarName(String name) {
        if (name.isEmpty() || name.isBlank() || name.length() < 6) {
            new IllegalArgumentException(RacingCarError.NOT_VALID_NAME.getMsg());
        }
    }

    private String moveForward() {

        this.position.append("-");

        return this.position.toString();
    }

    private String stop() {

        return this.position.toString();

    }

    public void choiceActive() {
        OneDigitRandomNumber randomNumber = new OneDigitRandomNumber();

        if (randomNumber.judgmentFourOrMore()) {

            System.out.println(this.name + " : " + this.moveForward());

        } else {

            System.out.println(this.name + " : " + this.stop());

        }
    }
}
