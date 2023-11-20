package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.subclass.MockCar;

import java.util.stream.Stream;


class CarTest {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class move {

        @DisplayName("move 메소드 테스트")
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void move_메소드_테스트(MockCar mockCar, int expected) {
            mockCar.move();
            Assertions.assertThat(mockCar.getTotalMovedDistance()).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of((new MockCar("pobi", 4)), 5),
                    Arguments.of((new MockCar("juni")), 1),
                    Arguments.of(new MockCar("zeka", 2), 3)
            );
        }

    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class getTotalMovedDistance{
        @DisplayName("getTotalMovedDistance 메소드 테스트")
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void getTotalMovedDistance_메소드_테스트(MockCar mockCar,int expected) {
            Assertions.assertThat(mockCar.getTotalMovedDistance()).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(new MockCar("pobi", 4),4),
                    Arguments.of(new MockCar("juni"),0),
                    Arguments.of(new MockCar("zeka", 2),2)
            );
        }

    }




}