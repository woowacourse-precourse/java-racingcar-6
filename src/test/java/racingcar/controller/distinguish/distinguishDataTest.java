package racingcar.controller.distinguish;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class distinguishDataTest {
    Distinguish distinguish = new distinguishData();

    @Test
    void string_6글자_이름_넣었을때_오류(){
        String error = "asdf  ";
        assertThatThrownBy(() -> distinguish.distinguishName(error))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void int_횟수에서_글자_넣었을때_오류(){
        String error = "as";
        assertThatThrownBy(() -> distinguish.distinguishNum(error))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void string_이름중_공백으로만_이루어진_경우(){
        String error = "     ";
        assertThatThrownBy(()->distinguish.distinguishName(error))
                .isInstanceOf(IllegalArgumentException.class);
    }
}