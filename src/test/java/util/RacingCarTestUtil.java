package util;

import static racingcar.config.CarMoveRuleConfig.setCustomCarMoveRule;

import java.io.ByteArrayInputStream;
import java.util.stream.IntStream;

import racingcar.model.car.Car;
import racingcar.model.car.CarMoveRule;

public class RacingCarTestUtil {
    public static void moveCar(Car car, int distance) {
        IntStream.range(0, distance).forEach(i -> car.goOrStop());
    }

    public static void setAlwaysCarMoveRule() {
        CarMoveRule alwaysMove = () -> true;
        setCustomCarMoveRule(alwaysMove);
    }

    public static void setAlwaysCarStopRule() {
        CarMoveRule alwaysStop = () -> false;
        setCustomCarMoveRule(alwaysStop);
    }

    public static void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
