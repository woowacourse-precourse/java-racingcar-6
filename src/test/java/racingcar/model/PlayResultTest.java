package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.enums.CarType;
import racingcar.enums.Common;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayResultTest {

    final String carName = "isaac";
    final String distance = "-----";


    @Test
    void PlayResult() {
        PlayResult result = new PlayResult(new Car("isaac"));
    }

    @Test
    void get() {
        Car car = new Car("isaac");
        assertRandomNumberInRangeTest(() -> {
            car.moveForward();
            car.moveForward();
            car.moveForward();
            car.moveForward();
            car.moveForward();
            PlayResult result = new PlayResult(car);
            assertThat(result.get(CarType.CAR_NAME)).isEqualTo(carName);
            assertThat(result.get(CarType.DISTANCE)).isEqualTo(distance);
        }, Common.STANDARD_NUMBER.getIntValue(), Common.STANDARD_NUMBER.getIntValue(), Common.STANDARD_NUMBER.getIntValue(), Common.STANDARD_NUMBER.getIntValue(), Common.STANDARD_NUMBER.getIntValue());
        car.moveForward();

    }
}