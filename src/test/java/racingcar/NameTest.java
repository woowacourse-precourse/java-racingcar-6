package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.ExceptionMessage.CAR_NAME_BLANK_EXCEPTION;
import static racingcar.ExceptionMessage.CAR_NAME_LENGTH_EXCEPTION;
import static racingcar.ExceptionMessage.CAR_NAMV_VALUE_EXCEPTION;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

    @Test
    void 공백이_처음에_포함되면_안_된다_예외() {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Name name = Name.from("  bob");
        });
        // then
        assertThat(exception.getMessage()).isEqualTo(CAR_NAME_BLANK_EXCEPTION.toString());
    }

    @Test
    void 공백이_마지막에_포함되면_안_된다_예외() {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Name name = Name.from("bob  ");
        });
        // then
        assertThat(exception.getMessage()).isEqualTo(CAR_NAME_BLANK_EXCEPTION.toString());
    }

    @Test
    void 공백이_중간에_포함되면_안_된다_예외() {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Name name = Name.from("b o b");
        });
        // then
        assertThat(exception.getMessage()).isEqualTo(CAR_NAME_BLANK_EXCEPTION.toString());
    }

    @Test
    void 한자는_입력되면_안_된다_예외() {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Name name = Name.from("崔賢俊");
        });
        // then
        assertThat(exception.getMessage()).isEqualTo(CAR_NAMV_VALUE_EXCEPTION.toString());
    }

    @Test
    void 한글은_입력_가능하다() {
        // given & when
        Name name = Name.from("존");
    }

    @Test
    void 특수기호는_입력되면_안_된다() {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Name name = Name.from("?-bob");
        });
        // then
        assertThat(exception.getMessage()).isEqualTo(CAR_NAMV_VALUE_EXCEPTION.toString());
    }

    @Test
    void 숫자는_입력_가능하다() {
        // given & when
        Name name = Name.from("1a9");
    }
}
