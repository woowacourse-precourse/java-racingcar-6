package racingcar.domain.game.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.Err;

class CarNameTest {

    @ParameterizedTest
    @DisplayName("자동차 이름이 null 또는 길이가 0인 경우, CarName 객체 생성 시 예외 발생")
    @ValueSource(strings = {"", " "})
    void should_Throw_Exception_For_Null_Or_Empty_CarName(String name) {
        // when
        // then
        assertThatThrownBy(() -> CarName.from(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Err.INVALID_CAR_NAME_MIN_LENGTH.getMessage());
    }

    @ParameterizedTest
    @DisplayName("자동차 이름의 길이가 5글자를 넘어가면 CarName 객체 생성 시 예외 발생")
    @ValueSource(strings = {"rrrrrrrr", "pobiii", "yehhhhhhhhhhhhhhhh"})
    void should_Throw_Exception_For_Exceeding_CarName_Max_Length(String name) {
        // when
        // then
        assertThatThrownBy(() -> CarName.from(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Err.INVALID_CAR_NAME_MAX_LENGTH.getMessage());
    }

}