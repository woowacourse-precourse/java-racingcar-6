package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.exception.car.BlankCarNameException;
import racingcar.exception.car.CarNameRangeException;
import racingcar.exception.car.DuplicateCarNameException;
import racingcar.exception.car.OnlyCommaInputException;

class ValidatorTest {
    private static final String ONLY_COMMA_NOT_ALLOWED_MESSAGE = "쉼표(,)사이에 이름을 입력해주세요.";
    private static final String CAR_NAME_OUT_OF_RANGE_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";
    private static final String REQUEST_CAR_NAME_INPUT_MESSAGE = "자동차 이름을 입력하세요.";
    private static final String DUPLICATE_CAR_NANE_MESSAGE = "중복된 자동차 이름입니다.";

    @Test
    void 쉼표만_입력하면_예외_발생() {
        String carNames = ",,,,,,,,,,,";

        assertThatThrownBy(() -> Validator.carNameValidator(carNames))
                .isInstanceOf(OnlyCommaInputException.class)
                .hasMessage(ONLY_COMMA_NOT_ALLOWED_MESSAGE);
    }

    @Test
    void 자동차_이름이_5글자_초과_시_예외_발생() {
        String carNames = "Jwbase, car1";

        assertThatThrownBy(() -> Validator.carNameValidator(carNames))
                .isInstanceOf(CarNameRangeException.class)
                .hasMessage(CAR_NAME_OUT_OF_RANGE_MESSAGE);
    }

    @Test
    void 자동차_이름에_공백이_있으면_예외_발생() {
        String carNames = "";

        assertThatThrownBy(() -> Validator.carNameValidator(carNames))
                .isInstanceOf(BlankCarNameException.class)
                .hasMessage(REQUEST_CAR_NAME_INPUT_MESSAGE);
    }

    @Test
    void 중복된_자동차_이름이_있으면_예외_발생() {
        String carNames = "자동차, 자동차";

        assertThatThrownBy(() -> Validator.carNameValidator(carNames))
                .isInstanceOf(DuplicateCarNameException.class)
                .hasMessage(DUPLICATE_CAR_NANE_MESSAGE);
    }
}