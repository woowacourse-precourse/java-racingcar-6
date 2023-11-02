package racingcar.validator;


import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarNameValidatorTest {

    @Test
    void 자동차이름에_빈문자_입력() {
        assertSimpleTest(() -> assertThatThrownBy(() -> CarNameValidator.checkCarNamesInput(""))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름에_공백_있음() {
        assertSimpleTest(() -> assertThatThrownBy(() -> CarNameValidator.checkCarNamesInput("자동차1, ,자동차2"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름_5글자_초과() {
        assertSimpleTest(() -> assertThatThrownBy(() -> CarNameValidator.checkCarNamesInput("자동차1,다섯글자가넘는자동차"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름_1글자_미만() {
        assertSimpleTest(() -> assertThatThrownBy(() -> CarNameValidator.checkCarNamesInput("자동차1,"))
                .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() -> assertThatThrownBy(() -> CarNameValidator.checkCarNamesInput("자동차1,,자동차2"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름이_중복() {
        assertSimpleTest(() -> assertThatThrownBy(() -> CarNameValidator.checkCarNamesInput("자동차,자동차"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
