package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;

class CarTest {
    private static final int MAX_NAME_LENGTH = 5;

    private static Stream<Arguments> testMoveCountAndRandomNumber() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(0, 1),
                Arguments.of(0, 2),
                Arguments.of(0, 3),
                Arguments.of(1, 4),
                Arguments.of(1, 5),
                Arguments.of(1, 6),
                Arguments.of(1, 7),
                Arguments.of(1, 8),
                Arguments.of(1, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("testMoveCountAndRandomNumber")
    void getMoveCount_테스트(int expectedMoveCount, int randomNumber) {
        //given
        Car pobi = new Car("pobi");

        //when, then
        assertRandomNumberInRangeTest(
                () -> {
                    pobi.moveIfSatisfy();
                    int moveCount = pobi.getMoveCount();
                    assertThat(moveCount).isEqualTo(expectedMoveCount);
                },
                randomNumber
        );
    }

    @Test
    void 자동차_이름_정상동작() {
        // given
        String carName = "pobi";
        // when
        Car car = new Car(carName);
        // then
        assertThat(car.getName()).isEqualTo("pobi");
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