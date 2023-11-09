package racingcar.domain;

import racingcar.message.OutputMessage;
import racingcar.resource.CarGameValue;
import racingcar.util.LetterUtil;

public class Car implements Comparable<Car> {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public void isSixLengthName() {
        if (this.name.length() != 6) {
            throw new IllegalArgumentException();
        }
    }

//    public int getPosition() {
//        return this.position;
//    }

    public void move(final int randomNumber) {
        if (moveCheck(randomNumber)) {
            this.position += CarGameValue.POWER.getValue();
        }
    }

    public String result() {
        return this.name + " : " + LetterUtil.sameLetterPaste(OutputMessage.RACE.getValue(), this.position);
    }

//    public boolean isSamePosition(int winnerPosition) {
//        return this.position == winnerPosition;
//    }

    // 코드 리팩토링
    public boolean isSamePosition(Car other) {
        return this.position == other.position;
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }

    private boolean moveCheck(final int randomNumber) {
        return randomNumber >= CarGameValue.CAR_MOVE_MORE_THAN_NUMBER.getValue();
    }
}
