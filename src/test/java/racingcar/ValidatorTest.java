package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.Test;
import racingcar.util.CarNameValidator;
import racingcar.util.ExceptionMessage;
import racingcar.util.TrialValidator;

public class ValidatorTest {


    @Test
    void 자동차_이름이_5보다_크면_에러발생() {
        String input = "자동차1,자동차2,에러자동자입니다";
        assertThatThrownBy(() -> {
            new CarNameValidator().validation(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
    }

    @Test
    void 자동차_이름이_정상적인_경우() {
        String input = "자동차1,자동차2,자동차3";

        assertThatCode(() -> new CarNameValidator().validation(input))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차_개수가_1개일_경우_에러발생() {
        String input = "자동차1";
        assertThatThrownBy(() -> {
            new CarNameValidator().validation(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_NUMBER_OF_CARS.getMessage());
    }

    @Test
    void 자동차_이름에_공백이_포함되어_있는_경우_에러발생() {
        String input = "자동차1,자동차2,에 러~~";
        assertThatThrownBy(() -> {
            new CarNameValidator().validation(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_CAR_NAME_HAS_SPACE.getMessage());
    }

    @Test
    void 자동차_이름이_중복일_경우_에러발생() {
        String input = "에러,에러,에러";
        assertThatThrownBy(() -> {
            new CarNameValidator().validation(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_CAR_NAME_DUPLICATE.getMessage());
    }

    @Test
    void 휫수입력이_0일_경우_에러발생() {
        String input = "0";
        assertThatThrownBy(() -> {
            new TrialValidator().validation(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_NOT_NATURAL_NUMBER.getMessage());
    }

    @Test
    void 휫수입력이_정상적인_경우() {
        String input = "3";

        assertThatCode(() -> new TrialValidator().validation(input))
                .doesNotThrowAnyException();
    }

    @Test
    void 휫수입력이_숫자가_아닐_경우_에러발생() {
        String input = "a";
        assertThatThrownBy(() -> {
            new TrialValidator().validation(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_NOT_NATURAL_NUMBER.getMessage());
    }

}
