package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.global.exception.ErrorMessage.INVALID_NAME_CHARACTERS;
import static racingcar.global.exception.ErrorMessage.INVALID_NAME_LENGTH;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    void 문자열을_통해_이름_객체를_생성한다() {
        // given
        String name = "poby";

        // when
        Name actual = Name.of(name);

        // then
        assertThat(actual.getValue()).isEqualTo(name);
    }

    @Test
    void 길이_제한을_초과하여_예외를_반환한다() {
        // given
        String name = "pobyyyy";

        // when & then
        try {
            Name.of(name);
        } catch (IllegalArgumentException e) {
            Assertions.assertThat(INVALID_NAME_LENGTH.getMessage()).isEqualTo(e.getMessage());
        }

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Name.of(name);
        });
    }

    @Test
    void 영문자_이외의_입력으로_예외를_반환한다() {
        // given
        String name = "poby@";

        // when & then
        try {
            Name.of(name);
        } catch (IllegalArgumentException e) {
            Assertions.assertThat(INVALID_NAME_CHARACTERS.getMessage()).isEqualTo(e.getMessage());
        }

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Name.of(name);
        });
    }
}
