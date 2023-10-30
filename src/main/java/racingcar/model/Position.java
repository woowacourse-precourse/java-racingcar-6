package racingcar.model;

import java.util.stream.IntStream;
import racingcar.util.Constants;

public class Position {
    private int position;

    public Position() {
        this.position = 0;
    }

    public void validatePosition(int randomNum) {
        int minValue = Integer.parseInt(Constants.MINIMUM_DISTANCE_SIZE.constant);
        if (randomNum >= minValue) {
            position++;
        }
    }

    public String getStringPosition() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, this.position).forEach(i -> sb.append("-"));
        return sb.toString();
    }

    public int getPosition() {
        return this.position;
    }
}
