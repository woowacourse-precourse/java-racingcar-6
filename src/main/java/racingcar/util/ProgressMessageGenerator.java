package racingcar.util;

import racingcar.domain.Car;

public class ProgressMessageGenerator {

    public static String generateProgressStateMessage(Car car) {
        String messageFormat = "%s : %s";
        return messageFormat.formatted(car.getName(), car.getDash());
    }
}
