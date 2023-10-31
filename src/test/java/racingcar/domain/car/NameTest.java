package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.config.GameConfig.NAME_LENGTH_CONDITION;
import static racingcar.domain.car.Name.validate;
import static racingcar.exception.ErrorMessage.VALIDATE_EMPTY_FOR_EACH_NAME;
import static racingcar.exception.ErrorMessage.VALIDATE_LENGTH_FOR_EACH_NAME;

@DisplayName("NameTest")
class NameTest {

    @Test
    @DisplayName("자동차 이름이 빈 문자열일 경우 예외를 반환한다.")
    void validateEmpty() {
        // given
        String input = "";

        // when, then
        assertThatThrownBy(() -> validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(VALIDATE_EMPTY_FOR_EACH_NAME.getMessage());
    }

    @Test
    @DisplayName("이름의 길이가 기준값 초과일 경우 예외를 반환한다.")
    void validateLength() {
        // given
        String input = "holyPigeon";

        // when, then
        assertThatThrownBy(() -> validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(VALIDATE_LENGTH_FOR_EACH_NAME.getMessage(), NAME_LENGTH_CONDITION.getNumber()));
    }

    @Test
    @DisplayName("자동차의 이름을 반환한다.")
    void getName() {
        // given
        String input = "name1";
        Name name = new Name(input);

        // when
        String getName = name.getName();

        // then
        assertThat(input).isEqualTo(getName);
    }
}