package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.TestConstants.TEST_CAR_NAME;
import static racingcar.util.TestConstantsProvider.provideInvalidMovingNumberConstants;
import static racingcar.util.TestConstantsProvider.provideValidMovingNumberConstants;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;

public class CarTest {

    @Nested
    @TestInstance(Lifecycle.PER_CLASS)
    @DisplayName("자동차 전진/ 정지 테스트")
    class CarMovingTest extends NsTest {
        Car testCar;

        @BeforeEach
        void beforeEach() {
            testCar = Car.create(TEST_CAR_NAME);
        }

        @ParameterizedTest(name = "임의의 수가 {0}일때 위치는 {1}이다.")
        @DisplayName("전진 테스트")
        @MethodSource("provideValidMovingNumber")
        void movingTest(int progress, int expectedProgress) {
            assertSimpleTest(() -> {
                        testCar.go(progress);
                        assertThat(testCar.getProgress()).isEqualTo(expectedProgress);
                    }
            );
        }

        @ParameterizedTest(name = "임의의 수가 {0}일때 예외가 발생한다.")
        @DisplayName("예외 테스트")
        @MethodSource("provideInvalidMovingNumber")
        void exceptionTest(int invalidProgress) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> testCar.go(invalidProgress))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        private Stream<Arguments> provideValidMovingNumber() {
            return provideValidMovingNumberConstants();
        }

        private Stream<Arguments> provideInvalidMovingNumber() {
            return provideInvalidMovingNumberConstants();
        }


        @Override
        protected void runMain() {
        }
    }
}
