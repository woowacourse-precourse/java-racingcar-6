package racingcar.utils.validate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ExceptionMessage.DIVIDER_IN_EDGE;
import static racingcar.constant.ExceptionMessage.NAME_CONTAINS_BLANK;
import static racingcar.constant.ExceptionMessage.NAME_LENGTH_NOT_IN_RANGE;
import static racingcar.constant.ExceptionMessage.NO_INPUT;
import static racingcar.constant.ExceptionMessage.ROUND_CONTAIN_NOT_ONLY_NUM;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.InputStringConstant;

class InputValidatorTest {

    private static final String[] NORMAL_INPUT = {"pobi", "woo", "jun"};
    private static final String[] CONTAIN_BLANK = {" pobi", "woo"};
    private static final String NAME_LENGTH_OVER_FIVE = "popobi,jun";
    private static final String NAME_LENGTH_ZERO = "pobi,,hello";
    private static final String DIVIDER_IN_START = ",pobi,jun,woni";
    private static final String DIVIDER_IN_END = "pobi,jun,woni,";
    private static final String EMPTY_INPUT = "";

    private static final String NOT_NUM = "hello";
    private static final String KOR = "안뇽";


    @Test
    void 정상이름은_예외를_발생시키지_않는다() {
        InputValidator.validateName(NORMAL_INPUT);
    }

    @Test
    void 이름에_공백이포함되면_예외를_발생시킨다() {
        assertThatThrownBy(() -> InputValidator.validateName(CONTAIN_BLANK))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_CONTAINS_BLANK.getMessage());
    }

    @Test
    void 제대로된_입력이아닌_입력이_들어오면_예외를_발생시킨다() {
        assertThatThrownBy(() -> InputValidator.validateInput(EMPTY_INPUT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NO_INPUT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {DIVIDER_IN_START, DIVIDER_IN_END})
    void 양끝에_구분가_있으면_예외를_발생시킨다(String input) {
        assertThatThrownBy(() -> InputValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIVIDER_IN_EDGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {NAME_LENGTH_OVER_FIVE, NAME_LENGTH_ZERO})
    void 이름에_5글자_이상이면_또는_0글자면_예외를_발생시킨다(String input) {
        String[] names = input.split(InputStringConstant.INPUT_NAME_DIVIDER.getValue());

        assertThatThrownBy(() -> InputValidator.validateName(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_LENGTH_NOT_IN_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {NOT_NUM, KOR})
    void 라운드_수는_숫자만_입력받을수_있다(String input) {
        assertThatThrownBy(() -> InputValidator.validateRoundNum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ROUND_CONTAIN_NOT_ONLY_NUM.getMessage());
    }

}