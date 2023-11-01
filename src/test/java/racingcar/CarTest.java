package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.message.ErrorMessage;

public class CarTest {

    @DisplayName("자동차 이름 생성 성공 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", "pobi", "a2", "abcd", "12345"})
    void CarNameSuccessTest(String name) {
        Car car = new Car(new CarName(name));

        Assertions.assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름 생성 실패 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "         ", "123456", "thisIsMoreThenFour"})
    void CarNameFailTest(String name) {
        Assertions.assertThatThrownBy(() -> {
                    new Car(new CarName(name));
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CAR_NAME);
    }
}
