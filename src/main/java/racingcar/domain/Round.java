package racingcar.domain;

import racingcar.util.Constants;
import racingcar.util.ResultMessage;

public class Round {
    private int position;

    public Round() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }


    public void move(int randomNumber) {
        if (randomNumber >= Constants.MOVING_FORWARD) {
            this.position++;
        }
    }


    public String getRecord(String name) {
        StringBuilder record = new StringBuilder();
        record.append(String.format(ResultMessage.ROUND_RECORD, name));
        for (int i = 0; i < position; i++) {
            record.append(Constants.HYPHEN);
        }
        return record.toString();
    }
}
