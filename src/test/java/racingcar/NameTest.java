package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.ExceptionMessage.CAR_NAME_BLANK_EXCEPTION;
import static racingcar.ExceptionMessage.CAR_NAME_LENGTH_EXCEPTION;
import static racingcar.ExceptionMessage.CAR_NAMV_VALUE_EXCEPTION;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Name;

public class NameTest {

    @Test
    void 이름은_5자_이하만_가능하다_정상() {
        // given & when
        Name name = Name.from("john");
    }

    @Test
    void 이름은_5자_이하만_가능하다_예외() {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Name name = Name.from("nickname");
        });
        // then
        assertThat(exception.getMessage()).isEqualTo(CAR_NAME_LENGTH_EXCEPTION.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"  bob", "bob  ", "b o b", "  "})
    void 공백이_포함되면_안된다(final String value) {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Name name = Name.from(value);
        });
        // then
        assertThat(exception.getMessage()).isEqualTo(CAR_NAME_BLANK_EXCEPTION.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"존", "1a9"})
    void 한글이나_알파벳_숫자는_가능하다(final String value) {
        // given & when
        Name name = Name.from(value);
    }

    @ParameterizedTest
    @ValueSource(strings = {"崔はлن", "?-bob"})
    void 한글과_알파벳_숫자를_제외한_모든_문자는_안된다(final String value) {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Name name = Name.from(value);
        });
        // then
        assertThat(exception.getMessage()).isEqualTo(CAR_NAMV_VALUE_EXCEPTION.toString());
    }
}
