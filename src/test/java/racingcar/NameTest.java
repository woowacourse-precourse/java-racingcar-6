package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.ExceptionMessage.CAR_NAME_BLANK_EXCEPTION;
import static racingcar.ExceptionMessage.CAR_NAME_LENGTH_EXCEPTION;

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
}
