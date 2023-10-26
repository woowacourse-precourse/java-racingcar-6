package racingcar.util;

import racingcar.domain.Car;

public class StringUtil {

    public String makeResultLine(Car car) {
        String format = "%s : %s";
        return String.format(format, car.getName(), "-".repeat(car.getPosition()));
    }
}
