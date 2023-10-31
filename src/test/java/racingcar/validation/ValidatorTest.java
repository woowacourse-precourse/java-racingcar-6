package racingcar.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 문자열에_컴마가_포함되어_있어야_한다() {
        assertDoesNotThrow(
                () -> Validator.validateContainsComma("pobi,cobi"));
    }

    @Test
    void 문자열에_컴마가_포함되어_있지않으면_예외가_터진다() {
        assertThatThrownBy(() -> Validator.validateContainsComma("pobicobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름은_쉼표를_기준으로_구분하며_이름은_5자이하만_가능하다() {
        assertDoesNotThrow(
                () -> Validator.validateNames("pobi,cobi,sobi"));
    }

    @Test
    void 자동차_이름은_쉼표를_기준으로_구분하며_이름은_5자이하가_아니라면_예외가_터진다() {
        assertThatThrownBy(() -> Validator.validateNames("pobicobi"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateNames("pobiaa,cobi"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateNames("pobi,cobi,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 동명이인이_존재하지_않으면_예외가_터지지_않는다() {
        assertDoesNotThrow(
                () -> Validator.validateDuplicateName("pobi,dobi,sobi"));
    }

    @Test
    void 동명이인이_존재하면_예외가_터진다() {
        assertThatThrownBy(() -> Validator.validateDuplicateName("pobi,dobi,pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}