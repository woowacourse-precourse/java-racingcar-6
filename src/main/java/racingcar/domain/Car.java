package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.OutputMessage;

public class Car {

    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int MOVE_NUMBER = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void race() {
        if (isOverMoveNumber()) {
            position++;
        }
    }

    private boolean isOverMoveNumber() {
        return pickRandomNumber() >= MOVE_NUMBER;
    }
    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }

    public String getRaceResult() {
        StringBuilder sb = new StringBuilder();
        OutputMessage resultMessage = OutputMessage.RACING_RESULT;
        sb.append(String.format(resultMessage.getMessage(), name));
        sb.append(OutputMessage.ROAD.getMessage().repeat(position));
        sb.append(OutputMessage.NEW_LINE.getMessage());
        return sb.toString();
    }
}
