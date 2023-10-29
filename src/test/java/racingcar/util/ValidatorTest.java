package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ValidatorTest extends NsTest {

    Validator validator = new Validator();
    @Test
    void 자동차_이름_입력값_비어있음_오류() {
        assertThatThrownBy(() -> validator.validateCarNamesInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력값_쉼표로_끝남_오류() {
        assertThatThrownBy(() -> validator.validateCarNamesInput("a,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이릅_입력값_공백_있음_오류() {
        assertThatThrownBy(() -> validator.validateCarNamesInput("a b"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력값_중복_오류() {
        assertThatThrownBy(() -> validator.validateCarNamesInput("a,b,a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력값_5자_초과_오류() {
        assertThatThrownBy(() -> validator.validateCarNamesInput("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력값_연속_쉼표_오류() {
        assertThatThrownBy(() -> validator.validateCarNamesInput("a,,b"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력값_성공() {
        validator.validateCarNamesInput("a,b,c");
    }

    @Test
    void 횟수_입력값_비어있음_오류() {
        assertThatThrownBy(() -> validator.validateNumRacesInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수_입력값_0_이하_오류() {
        assertThatThrownBy(() -> validator.validateNumRacesInput("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.validateNumRacesInput("-5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수_입력값_성공() {
        validator.validateNumRacesInput("5");
    }

    @Override
    protected void runMain() {
    }
}
