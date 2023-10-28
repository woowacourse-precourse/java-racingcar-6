package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

@DisplayName("자동차 모델에 대한 테스트")
class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"beom", "seok", "kevin", "test"})
    @DisplayName("자동차 생성 테스트")
    void initCar(String carName) {
        // give
        // when
        Car car = new Car(carName);

        // then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @ParameterizedTest
    @MethodSource("carNameProvider")
    @DisplayName("자동차의 이름 길이에 따른 예외처리 테스트")
    void init_CarNameLengthThanLimit_ThrownException(String carName) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Car(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "   ", "    ", "     "})
    @DisplayName("자동차의 이름으로 빈 문자열이 들어오면 예외를 호출한다.")
    void init_CarNameIsEmpty_ThrownException() {
        // given
        String carName = "";

        // when
        // then
        assertThatThrownBy(() -> new Car(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> carNameProvider() {
        return Stream.of(
                Arguments.of("beomsic"),
                Arguments.of("beomseok"),
                Arguments.of("kobeomseok"),
                Arguments.of("testname"),
                Arguments.of("123456"),
                Arguments.of("12345678"),
                Arguments.of("123456789")
        );
    }
}
