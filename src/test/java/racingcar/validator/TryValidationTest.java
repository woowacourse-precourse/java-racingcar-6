package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TryValidationTest {
    TryValidation valid = new TryValidation();

    @Test
    void 숫자가아닌_입력_또는_1미만_숫자입력시_예외_발생() {
        List<String> numberList = new ArrayList<>();
        numberList.add("wooooo,maro");
        numberList.add("0123");
        numberList.add("-1");

        for (String number : numberList) {
            assertThatThrownBy(() -> valid.checkTryNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1이상의 숫자를 입력하세요");
        }
    }

}
