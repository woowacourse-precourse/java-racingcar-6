package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumbersTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    @Test
    @DisplayName("랜덤 값 모델 테스트")
    void testRandomNumbers() {

        assertRandomNumberInRangeTest(
            () -> assertThat(new RandomNumbers(2).getRandomNumberList()).contains(false, true, false),
                STOP,MOVING_FORWARD, STOP
        );
    }




}