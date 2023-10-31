package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.utils.Constants;
import racingcar.utils.InputValidator;

public class InputValidatorTest {

    @Test
    void 자동차_이름_중복에_대한_예외_처리() {
        String[] carNames = {"carA", "carA", "carB"};

        assertThatThrownBy(() -> InputValidator.validateCarNames(carNames)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(Constants.DUPLICATE_CAR_NAMES);

    }

    @Test
    void 자동차_이름_공백에_대한_예외_처리() {
        String[] carNames = {" ", "carA", "carB"};

        assertThatThrownBy(() -> InputValidator.validateCarNames(carNames)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(Constants.EMPTY_CAR_NAMES);
    }

    @Test
    void 자동차_이름_길이에_대한_예외_처리() {
        String[] carNames = {"longerThanFive"};

        assertThatThrownBy(() -> InputValidator.validateCarNames(carNames)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(Constants.EXCEED_NAME_LENGTH);
    }

    @Test
    void 시도_횟수_개수에_대한_예외_처리() {
        int tryCount = 0;

        assertThatThrownBy(() -> InputValidator.validateTryCount(tryCount)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(Constants.INVALID_TRY_COUNT);
    }

    @Test
    void 여러대_자동차_이름_구분_예외_처리() {
        String input = "carA. carA? carB";

        assertThatThrownBy(() -> InputValidator.validateCarNameWithComma(input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(Constants.INVALID_CAR_NAMES);
    }


}
