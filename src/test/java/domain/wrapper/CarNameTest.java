package domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.wrapper.Name;

import static racingcar.domain.constant.CarConstant.CAR_NAME_MAX_LENGTH;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.util.message.ExceptionMessage.BLANK_MESSAGE;
import static racingcar.util.message.ExceptionMessage.LENGTH_MESSAGE;

class CarNameTest {

    @ParameterizedTest
    @DisplayName("정상적으로 입력했을 경우 예외를 처리하지 않는다.")
    @ValueSource(strings = {"junpk", "jney", "pobi", "neo"})
    void givenNormalCarName_thenSuccess(final String carName) {
        assertThat(Name.create(carName))
                .isInstanceOf(Name.class);

        assertThatCode(() -> Name.create(carName))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("이름이 5자보다 길다면 예외를 처리한다.")
    @ValueSource(strings = {"pobiii", "sugggg"})
    void givenFiveOverLength_thenFail(final String carName) {
        assertThatThrownBy(() -> Name.create(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(LENGTH_MESSAGE.getValue(), CAR_NAME_MAX_LENGTH.getValue()));
    }

    @ParameterizedTest
    @DisplayName("이름이 공백일 경우 예외를 처리한다.")
    @EmptySource
    void givenBlankName_thenFail(final String carName) {
        assertThatThrownBy(() -> Name.create(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(BLANK_MESSAGE.getValue(), "이름"));
    }
}