package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @Test
    @DisplayName("문자열을 이용해 생성할 수 있다.")
    void canConstructByString() {
        // given
        final String name = "wan";

        // when
        CarName carName = new CarName(name);

        // then
        assertThat(carName.name()).isEqualTo(name);
    }

    @ParameterizedTest(name = "[{index}] : {0}")
    @ValueSource(strings = {"longname", "toomuchlongname", ""})
    @DisplayName("잘못된 크기의 이름이 입력되었을 때 IllegalArgumentException을 발생한다.")
    void throwsIllegalArgumentException_whenInvalidSizeNamesInput(final String name) {
        final String ERROR_MESSAGE_INVALID_SIZE = "자동차의 이름은 1자리 이상 5자리 이하입니다.";

        // when, then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> new CarName(name));
        assertThat(e.getMessage()).isEqualTo(ERROR_MESSAGE_INVALID_SIZE);
    }

    @Test
    @DisplayName("name() 이 저장된 이름을 반환한다.")
    void nameReturnSavedName() {
        // given
        final String input = "wan";
        CarName carName = new CarName(input);

        // when
        String name = carName.name();

        // then
        assertThat(name).isEqualTo(input);
    }
}