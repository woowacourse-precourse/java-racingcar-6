package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CarTest {

    private static final int MOVE_FORWARD = 4;
    private static final int STOP = 3;

    private Car sut;

    @BeforeEach
    void initCar() {
        sut = new Car("test");
    }

    @DisplayName("자동차 전진 테스트")
    @Test
    void moveForwardTest() {
        assertRandomNumberInRangeTest(sut::moveForwardRandomly, MOVE_FORWARD, MOVE_FORWARD);
        assertThat(sut).hasFieldOrPropertyWithValue("position", 1);
    }

    @DisplayName("자동차 정지 테스트")
    @Test
    void stayTest() {
        assertRandomNumberInRangeTest(sut::moveForwardRandomly, STOP, STOP);
        assertThat(sut).hasFieldOrPropertyWithValue("position", 0);
    }

    @DisplayName("자동차의 position과 전달받은 정수의 대소비교 테스트")
    @MethodSource("positionCompareTestDataProvider")
    @ParameterizedTest(name = "[{index}] comparison target: {0} => result: {1}")
    void positionCompareTest(int num, boolean expectedResult) {
        boolean actualResult = sut.isPositionGreaterThan(num);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> positionCompareTestDataProvider() {
        return Stream.of(
                arguments(1, false),
                arguments(-1, true)
        );
    }
}