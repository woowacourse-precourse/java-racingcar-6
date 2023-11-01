package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("자동차 이름이 유효성 검사에 걸리는지 확인하는 테스트")
    void isValidCarName() {
        //given
        String name = "judy";
        // then
        assertThat(false).isEqualTo(Validator.isValidCarName(name));
    }

    @Test
    void isEmpty() {
        //given
        String empty = "";
        String exist = "car";

        //then,when
        assertThat(true).isEqualTo(Validator.isEmpty(empty));
        assertThat(false).isEqualTo(Validator.isEmpty(exist));
    }

    @Test
    void isNotNumber() {
        //given
        String round = "3";
        String validRound = "2F";

        //when, then
        assertThat(false).isEqualTo(Validator.isNotNumber(round));
        assertThat(true).isEqualTo(Validator.isNotNumber(validRound));
    }
}