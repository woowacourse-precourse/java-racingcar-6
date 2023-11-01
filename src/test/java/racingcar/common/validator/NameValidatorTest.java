package racingcar.common.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NameValidatorTest {

    @Test
    public void 이름_길이_짧음() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> NameValidator.validate(""));
    }

    @Test
    public void 이름_길이_길음() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> NameValidator.validate("hyunjin".repeat(10)));
    }

    @Test
    public void 이름_숫자_포함() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> NameValidator.validate("hyunjin1234"));
    }

    @Test
    public void 이름_특수문자_포함() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> NameValidator.validate("hyunjin!"));
    }

    @Test
    public void 이름_공백_포함() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> NameValidator.validate(" "));
    }
}
