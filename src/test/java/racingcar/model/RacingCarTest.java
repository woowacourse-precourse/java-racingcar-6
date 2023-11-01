package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    private final RacingCar testCar = new RacingCar("testCar");

    @Test
    @DisplayName("0~9 랜덤 숫자가 4 이상이면 전진")
    public void moveForwardAccordingToRandomNumberTest() {
        // 자동차가 움직일 확률이 작지 않도록 충분히 큰 숫자
        int loopCount = 10000;
        IntStream.rangeClosed(1, loopCount)
                .forEach(index -> testCar.moveForwordOrNot());
        assertThat(testCar.getCurrentPosition())
                .isGreaterThan(0);
        System.out.println(testCar.getCurrentPosition());
    }
}
