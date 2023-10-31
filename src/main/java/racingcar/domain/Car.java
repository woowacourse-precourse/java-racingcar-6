package racingcar.domain;

import racingcar.message.OutputMessage;
import racingcar.resource.CarGameValue;
import racingcar.util.LetterUtil;
import racingcar.util.RandomUtil;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position =position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(final int randomNumber) {
        if (moveCheck(randomNumber)) {
            this.position += CarGameValue.POWER.getValue();
        }
    }

    public String result() {
        return this.name + " : " + LetterUtil.sameLetterPaste(OutputMessage.RACE.getValue(), this.position);
    }

    public boolean isSamePosition(int winnerPosition) {
        return this.position == winnerPosition;
    }

    private boolean moveCheck(final int randomNumber) {
        return randomNumber >= CarGameValue.CAR_MOVE_MORE_THAN_NUMBER.getValue();
    }
}
