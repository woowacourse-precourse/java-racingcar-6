package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JudgmentTest {
    Judgment judgment=new Judgment();
    @Test
    @DisplayName("숫자가 4이상이면 전진 조건에 참이다.")
    void condition_true(){
        //given
        int num=4;

        //when
        boolean pass=judgment.isNumberFourOrMore(num);

        //then
        Assertions.assertThat(pass).isEqualTo(true);
    }

    @Test
    @DisplayName("숫자가 4미만이면 전진 조건이 아니다.")
    void condition_false(){
        //given
        int num=3;

        //when
        boolean pass=judgment.isNumberFourOrMore(num);

        //then
        Assertions.assertThat(pass).isEqualTo(false);
    }
}