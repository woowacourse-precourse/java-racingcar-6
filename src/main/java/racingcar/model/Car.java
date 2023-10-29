package racingcar.model;

import racingcar.constants.ErrorMessage;
import racingcar.constants.GameResultElement;
import racingcar.constants.RacingCarRole;
import racingcar.exception.CarNameLengthException;

import java.util.stream.IntStream;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > RacingCarRole.MAX_CAR_NAME_LENGTH.getValue()) {
            throw new CarNameLengthException(ErrorMessage.CAR_NAME_LENGTH_ERROR.getMessage());
        }
    }

    public void movePosition() {
        this.position++;
    }

    public String statusCarPosition() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(name).append(GameResultElement.COLON);
        IntStream.range(0, position)
                .forEach(i -> stringBuilder.append(GameResultElement.DASH));
        stringBuilder.append(GameResultElement.ENTER);

        return stringBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
