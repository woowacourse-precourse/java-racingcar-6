package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.subclass.MockCar;
import racingcar.system.SystemConstant;

import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;


class CarTest {


    private final int CANNOT_MOVE_VALUE = 2;
    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class move {

        @DisplayName("자동차가 전진하는 경우 move 메소드 테스트")
        @Test
        void 랜덤값이_4이상인_전진하는_경우() {
            assertRandomNumberInRangeTest(
                    () -> {
                        MockCar mockCar = new MockCar("pobi", 4);
                        mockCar.move();
                        assertThat(mockCar.getTotalMovedDistance())
                                .isEqualTo(5);
                    },
                    SystemConstant.MIN_MOVE_THRESHOLD
            );

        }

        @DisplayName("자동차가 정지해 있는 경우 move 메소드 테스트")
        @Test
        void 랜덤값이_4미만인_전진하지않는_경우() {
            assertRandomNumberInRangeTest(
                    () -> {
                        MockCar mockCar = new MockCar("pobi", 4);
                        mockCar.move();
                        assertThat(mockCar.getTotalMovedDistance())
                                .isEqualTo(4);
                    },
                    CANNOT_MOVE_VALUE
            );


        }

    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class getTotalMovedDistance {
        @DisplayName("getTotalMovedDistance 메소드 테스트")
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void getTotalMovedDistance_메소드_테스트(MockCar mockCar, int expected) {
            assertThat(mockCar.getTotalMovedDistance()).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(new MockCar("pobi", 4), 4),
                    Arguments.of(new MockCar("juni"), 0),
                    Arguments.of(new MockCar("zeka", 2), 2)
            );
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class compareTo {
        @DisplayName("compareTo 메소드 테스트")
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void compareTo_메소드_테스트(MockCar mockCar, MockCar other, int expected) {
            assertThat(mockCar.compareTo(other)).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(new MockCar("pobi", 4), new MockCar("mini", 3), 1),
                    Arguments.of(new MockCar("pobi"), new MockCar("mini", 2), -2),
                    Arguments.of(new MockCar("pobi", 2), new MockCar("mini", 2), 0)
            );
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class isSamePosition {
        @DisplayName("isSamePosition 메소드 테스트")
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void isSamePosition_메소드_테스트(MockCar mockCar, MockCar other, boolean expected) {
            assertThat(mockCar.isSamePosition(other)).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(new MockCar("pobi", 4), new MockCar("mini", 3), false),
                    Arguments.of(new MockCar("pobi"), new MockCar("mini", 2), false),
                    Arguments.of(new MockCar("pobi", 2), new MockCar("mini", 2), true)
            );
        }
    }

}