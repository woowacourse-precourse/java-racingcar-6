package racingcar.model;

import java.util.stream.IntStream;
import racingcar.constants.GameResultElement;
import racingcar.constants.RacingCarMove;
import racingcar.constants.RacingCarRole;
import racingcar.constants.message.ErrorMessage;
import racingcar.exception.car.CarNameLengthException;

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
        position += RacingCarMove.NEXT_POSITION.getValue();
    }

    public String statusCarPosition() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(name).append(GameResultElement.COLON);
        IntStream.range(RacingCarMove.END_ATTEMPT_NUMBER.getValue(), position)
            .forEach(i -> stringBuilder.append(GameResultElement.DASH));
        stringBuilder.append(GameResultElement.ENTER);

        return stringBuilder.toString();
    }

    public boolean isEqualCarPosition(int maxPosition) {
        return position == maxPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
