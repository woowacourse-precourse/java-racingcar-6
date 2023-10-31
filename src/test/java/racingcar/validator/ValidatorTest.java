package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ValidatorTest {
    private Validator validator;

    @Test
    void validateCarNames_입력값의_앞뒤에_쉼표가_있으면_예외_발생() {
        String input = ",aaaa,bbbb,cccc,";
        assertThatThrownBy(() -> Validator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력값입니다.");
    }

    @Test
    void validateCarNames_자동차의_이름이_영문과_숫자_형식이_아닐_경우_예외_발생() {
        String input = "aadk,bb#b,cccc";
        assertThatThrownBy(() -> Validator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 영문과 숫자로만 이루어져야 합니다.");
    }

    @Test
    void validateCarNames_각각의_이름이_5글자를_넘어가면_예외_발생() {
        String input = "aaaaaa,bbbbbb,ccccc";
        assertThatThrownBy(() -> Validator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자 이하로 만들어야 합니다.");
    }

    @Test
    void validateCarNames_중복된_값이_포함된_경우_예외_발생() {
        String input = "aaaaa,bbbbb,aaaaa";
        assertThatThrownBy(() -> Validator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 중복된 값이 있을 수 없습니다.");
    }

    @Test
    void validateCarNames_값이_들어있지_않은_경우_예외_발생() {
        String input = "abcd1,abcd2,,abcd5";
        assertThatThrownBy(() -> Validator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 공백이 될 수 없습니다.");
    }

    @Test
    void validateRoundValue_숫자가_아닌_값일_경우_예외_발생() {
        String input = "@";
        assertThatThrownBy(() -> Validator.validateRoundValue(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 회수는 숫자이어야 합니다.");
    }

    @Test
    void validateRoundValue_횟수가_1_이상이_아닐_경우_예외_발생() {
        String input = "0";
        assertThatThrownBy(() -> Validator.validateRoundValue(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 회수는 1회 이상을 입력해주세요.");
    }

}