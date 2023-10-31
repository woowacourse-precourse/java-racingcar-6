package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class ValidatorTest {

    @Test
    void 자동차_이름은_5글자_이하(){
        Assertions.assertThatThrownBy(() -> Validator.validateCarLength("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 반복_수는_자연수(){
        Assertions.assertThatThrownBy(() -> Validator.validateIsNumber("다섯번"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}