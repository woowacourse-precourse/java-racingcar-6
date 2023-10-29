package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ValidatorTest extends NsTest {

    Validator validator = new Validator();
    @Test
    void 자동차_이름_입력값_비어있음_오류() {
        assertThatThrownBy(() -> validator.validateInputIsNotEmpty(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력값_쉼표로_끝남_오류() {
        assertThatThrownBy(() -> validator.validateInputDoesNotEndWithComma("a,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이릅_입력값_공백_있음_오류() {
        assertThatThrownBy(() -> validator.validateInputDoesNotContainSpace("a b"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력값_중복_오류() {
        assertThatThrownBy(() -> validator.validateInputDoesNotContainDuplicate("a,b,a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력값_5자_초과_오류() {
        assertThatThrownBy(() -> validator.validateInputIsNotOverLength("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력값_연속_쉼표_오류() {
        assertThatThrownBy(() -> validator.validateInputDoesNotContainContinuousComma("a,,b"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력값_성공() {
        validator.validateInputIsNotEmpty("a");
        validator.validateInputDoesNotEndWithComma("a");
        validator.validateInputDoesNotContainSpace("a");
        validator.validateInputDoesNotContainDuplicate("a");
        validator.validateInputIsNotOverLength("a");
        validator.validateInputDoesNotContainContinuousComma("a");
    }

    @Override
    protected void runMain() {
    }
}
