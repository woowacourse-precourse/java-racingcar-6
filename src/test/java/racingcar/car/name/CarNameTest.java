package racingcar.car.name;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @DisplayName("CarName 생성 성공")
    @ParameterizedTest
    @ValueSource(strings = {"car", "race", "speed", "auto", "a"})
    void createCarName_success(String name) {
        assertThatCode(() -> new CarName(name))
                .doesNotThrowAnyException();
    }

    @DisplayName("CarName 생성 실패")
    @ParameterizedTest
    @ValueSource(strings = {"", "Car1", "racingcar", "Race", "carname", "12345", "     "})
    void createCarName_failure(String name) {

        Assertions.assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
