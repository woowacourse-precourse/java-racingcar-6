package racingcar.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidateInputTest {

    @Test
    void validateNamesInput_빈_이름이_있는_경우_예외_발생() {
        //given
        String inputNames = "woowa,,han,cours";

        //when

        //then
        assertThatThrownBy(() -> ValidateInput.validateNamesInput(inputNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 이름이 존재함니다.");
    }

    @Test
    void validateNamesInput_5글자를_초과한_이름이_있는_경우_예외_발생() {
        //given
        String inputNames = "woowa,han,course";

        //when

        //then
        assertThatThrownBy(() -> ValidateInput.validateNamesInput(inputNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("5글자를 초과한 이름이 입력되었습니다.");
    }

    @Test
    void validateRoundInput() {
        //given
        //when
        //then
    }
}