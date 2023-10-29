package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.util.ExceptionMessage;
import racingcar.util.Validator;

public class ValidatorTest {

    private static final Validator validator = new Validator();
    @Test
    void 자동차_이름이_5보다_크면_에러발생() {
        String input = "자동차1,자동차2,에러자동자입니다";
        assertThatThrownBy(() -> {
            validator.validationCarName(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
    }

    @Test
    void 자동차_개수가_1개일_경우_에러발생() {
        String input = "자동차1";
        assertThatThrownBy(() -> {
            validator.validationCarName(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_NUMBER_OF_CARS.getMessage());
    }

    @Test
    void 휫수입력이_0일_경우_에러발생() {
        String input = "0";
        assertThatThrownBy(() -> {
            validator.validationTrial(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
    }

    @Test
    void 휫수입력이_숫자가_아닐_경우_에러발생() {
        String input = "a";
        assertThatThrownBy(() -> {
            validator.validationTrial(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
    }

}
