package racingcar.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import utils.validator.ExceptionMessage;
import utils.validator.Validator;

public class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    void 공백_자동차이름_입력() {
        assertSimpleTest(() -> assertThatThrownBy(() -> validator.checkCarNamesInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.EMPTY_INPUT_ERROR.getMessage()));
    }

    @Test
    void 공백_게임횟수_입력() {
        assertSimpleTest(() -> assertThatThrownBy(() -> validator.checkGameCountInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.EMPTY_INPUT_ERROR.getMessage()));
    }

    @Test
    void 자동차이름_1글자미만() {
        assertSimpleTest(() -> assertThatThrownBy(() -> validator.checkCarNamesInput("car1,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.OUT_OF_LENGTH_CARNAME_ERROR.getMessage()));
        assertSimpleTest(() -> assertThatThrownBy(() -> validator.checkCarNamesInput("car1,car2,,car4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.OUT_OF_LENGTH_CARNAME_ERROR.getMessage()));
    }

    @Test
    void 자동차이름_5글자초과() {
        assertSimpleTest(() -> assertThatThrownBy(() -> validator.checkCarNamesInput("a,b,dh1010a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.OUT_OF_LENGTH_CARNAME_ERROR.getMessage()));
    }

    @Test
    void 공백_자동차이름() {
        assertSimpleTest(() -> assertThatThrownBy(() -> validator.checkCarNamesInput("car1, ,car3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.EMPTY_SPACE_INCLUDE_ERROR.getMessage()));
    }

    @Test
    void 자동차이름_중복() {
        assertSimpleTest(() -> assertThatThrownBy(() -> validator.checkCarNamesInput("우아,우아"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.DUPLICATE_CARNAME_ERROR.getMessage()));
    }

    @Test
    void 시도횟수_문자() {
        assertSimpleTest(() -> assertThatThrownBy(() -> validator.checkGameCountInput("one"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_INTEGER_ERROR.getMessage()));
    }
}