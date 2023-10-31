package racingcar.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void validateRoundInput_입력된_문자열이_정수가_아닌_경우_예외_발생() {
        //given
        String inputRound = "a";

        //when

        //then
        assertThatThrownBy(() -> ValidateInput.validateRoundInput(inputRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정수가 아닌 값이 입력되었습니다.");
    }

    @Test
    void validateRoundInput_입력된_이동_회수가_1보다_작은_경우_예외_발생() {
        //given
        String inputRound = "0";

        //when

        //then
        assertThatThrownBy(() -> ValidateInput.validateRoundInput(inputRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 회수가 1보다 작습니다.");
    }
}