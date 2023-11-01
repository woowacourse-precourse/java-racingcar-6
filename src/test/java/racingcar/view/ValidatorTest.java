package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Validator 클래스 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ValidatorTest {

    @Test
    void 사용자의_올바른_이름_입력을_받는다() {
        Validator.validateNameInput("abc");
        Validator.validateNameInput("a,b,c");
    }

    @Test
    void 빈_이름을_검사한다() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNameInput(""));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNameInput("a,"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNameInput(",a"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNameInput("a,,a"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNameInput(",,"));
    }

    @Test
    void 이름의_길이를_검사한다() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNameInput("abcdef"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNameInput("a,abcdef"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNameInput("abcdef,a"));
    }

    @Test
    void 잘못된_문자를_검사한다() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNameInput("1,abc"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNameInput("cde.abc"));
    }

    @Test
    void 사용자의_올바른_시도_입력을_받는다() {
        Validator.validateTryCountInput("1");
        Validator.validateTryCountInput("10");
    }

    @Test
    void 잘못된_시도를_검사한다() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateTryCountInput("0"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateTryCountInput("-1"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateTryCountInput("a"));
    }

    @Test
    void 중복된_이름을_검사한다() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateTryCountInput("a,a"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateTryCountInput("b,a,a"));
    }
}
