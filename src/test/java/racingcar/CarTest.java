package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;

class CarTest {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_STOP = 0;
    private static final int MIN_MOVING_FORWARD = 4;
    private static final int MOVE_SUCCESS = 1;
    private static final int MOVE_FAIL = 0;
    private Car pobiCar;

    @BeforeEach
    void setUp() {
        // given
        pobiCar = new Car("pobi");
    }

    private static Stream<Arguments> testMoveCountAndRandomNumber() {
        return Stream.of(
                Arguments.of(MOVE_FAIL, MIN_STOP),
                Arguments.of(MOVE_FAIL, MIN_STOP + 1),
                Arguments.of(MOVE_FAIL, MIN_STOP + 2),
                Arguments.of(MOVE_FAIL, MIN_STOP + 3),
                Arguments.of(MOVE_SUCCESS, MIN_MOVING_FORWARD),
                Arguments.of(MOVE_SUCCESS, MIN_MOVING_FORWARD + 1),
                Arguments.of(MOVE_SUCCESS, MIN_MOVING_FORWARD + 2),
                Arguments.of(MOVE_SUCCESS, MIN_MOVING_FORWARD + 3),
                Arguments.of(MOVE_SUCCESS, MIN_MOVING_FORWARD + 4),
                Arguments.of(MOVE_SUCCESS, MIN_MOVING_FORWARD + 5)
        );
    }

    @ParameterizedTest
    @MethodSource("testMoveCountAndRandomNumber")
    void getMoveCount_테스트(int expectedMoveCount, int randomNumber) {
        // when
        assertRandomNumberInRangeTest(
                () -> {
                    pobiCar.moveIfSatisfy();
                    int moveCount = pobiCar.getMoveCount();
                    // then
                    assertThat(moveCount).isEqualTo(expectedMoveCount);
                },
                randomNumber
        );
    }

    @Test
    void 자동차_이름_정상동작() {
        // when
        String carName = pobiCar.getName();
        // then
        assertThat(carName).isEqualTo("pobi");
    }

    @Test
    void 자동차_이름_예외처리() {
        // given
        String carName = "pobiii";
        // when, then
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이름이 " + MAX_NAME_LENGTH + "보다 깁니다.");
    }
}