package racingcar;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    private Validator validator = new Validator();

    //@Test
    //void validateInput_자동차이름_입력값의길이가_1000만_이하인가() {}

    @Test
    void validateInput_입력값이_영문자_한글_쉼표로_이루어져있는지() {
        String invalidInput = "한국,pobi,MYCAR,ahn!";

        Assertions.assertThatThrownBy(() -> validator.validateInput(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
