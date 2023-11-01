package racingcar.global.util;

import org.junit.jupiter.api.Test;
import racingcar.global.error.BusinessException;
import racingcar.global.error.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    Validator validator = new Validator();

    @Test
    void 올바른_자동차_이름_값이_주어지면_정상_동작한다() {
        // given
        String carsName = "joy,happy";

        // when & then
        validator.validateCarsName(carsName);
    }

    @Test
    void 자동차_이름으로_공백이_주어지면_예외가_발생한다() {
        // given
        String carsName = " ";

        // when & then
        assertThatThrownBy(() -> validator.validateCarsName(carsName))
                .isInstanceOf(BusinessException.class)
                .hasMessageContaining(ErrorMessage.IS_BLANK.getMessage());
    }

    @Test
    void 자동차_이름이_비어있으면_예외가_발생한다() {
        // given
        String carsName = "";

        // when & then
        assertThatThrownBy(() -> validator.validateCarsName(carsName))
                .isInstanceOf(BusinessException.class)
                .hasMessageContaining(ErrorMessage.IS_BLANK.getMessage());
    }

    @Test
    void 자동차_이름에_심볼이_포함되지_않으면_예외가_발생한다() {
        // given
        String carsName = "joyhappy";

        // when & then
        assertThatThrownBy(() -> validator.validateCarsName(carsName))
                .isInstanceOf(BusinessException.class)
                .hasMessageContaining(ErrorMessage.NOT_CONTAIN_SYMBOL.getMessage());
    }

    @Test
    void 자동차_이름의_처음_또는_마지막_위치에_심볼이_포함되면_예외가_발생한다() {
        // given
        String carsName = ",joyhappy";

        // when & then
        assertThatThrownBy(() -> validator.validateCarsName(carsName))
                .isInstanceOf(BusinessException.class)
                .hasMessageContaining(ErrorMessage.INVALID_SYMBOL_POSITION.getMessage());
    }

    @Test
    void 자동차_이름이_5자_초과면_예외가_발생한다() {
        // given
        String carsName = "joy,happyy";

        // when & then
        assertThatThrownBy(() -> validator.validateCarsName(carsName))
                .isInstanceOf(BusinessException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
    }

    @Test
    void 자동차_이름이_중복되면_예외가_발생한다() {
        // given
        String carsName = "joy,joy";

        // when & then
        assertThatThrownBy(() -> validator.validateCarsName(carsName))
                .isInstanceOf(BusinessException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_NAME.getMessage());
    }

    @Test
    void 올바른_시도할_회수_값이_주어지면_정상_동작한다() {
        // given
        String numberOfAttempts = "5";

        // when & then
        validator.validateNumberOfAttempts(numberOfAttempts);
    }

    @Test
    void 시도할_회수에_숫자가_아닌_값이_주어지면_예외가_발생한다() {
        // given
        String numberOfAttempts = "a";

        // when & then
        assertThatThrownBy(() -> validator.validateNumberOfAttempts(numberOfAttempts))
                .isInstanceOf(BusinessException.class)
                .hasMessageContaining(ErrorMessage.TYPE_MISMATCH.getMessage());
    }

    @Test
    void 시도할_회수에_0_이하의_숫자가_주어지면_예외가_발생한다() {
        // given
        String numberOfAttempts = "0";

        // when & then
        assertThatThrownBy(() -> validator.validateNumberOfAttempts(numberOfAttempts))
                .isInstanceOf(BusinessException.class)
                .hasMessageContaining(ErrorMessage.INVALID_COUNT.getMessage());
    }
}