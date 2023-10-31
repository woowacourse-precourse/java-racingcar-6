package racingcar.util.converter;

import java.util.StringJoiner;
import racingcar.config.Message;

public class NameAndDistanceMessageGenerator {

    private static final String MESSAGE_DELIMITER = " : ";
    private static final String DISTANCE_DISPLAY = "-";

    public String generate(String carName, int drivenDistance) {
        StringJoiner messageGenerator = new StringJoiner(MESSAGE_DELIMITER);
        messageGenerator.add(carName);
        messageGenerator.add(convertDistanceToDisplay(drivenDistance));
        return messageGenerator + Message.NEW_LINE;
    }

    private String convertDistanceToDisplay(int drivenDistance) {
        return DISTANCE_DISPLAY.repeat(drivenDistance);
    }
}
