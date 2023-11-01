package racingcar.domain.car.wrapper;

import org.junit.jupiter.api.Test;
import racingcar.constants.ErrorConsts;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {

    @Test
    void Name_생성자에_null_전달시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> new Name(null), ErrorConsts.NULL_CAR_NAME.getMessage());
    }

    @Test
    void Name_생성자에_공백_전달시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> new Name(""), ErrorConsts.BLANK_CAR_NAME.getMessage());
        assertThrows(IllegalArgumentException.class, () -> new Name("   "), ErrorConsts.BLANK_CAR_NAME.getMessage());
    }

    @Test
    void Name_생성자에_길이가_5보다_긴_문자열_전달시_예외_발생() {
        assertDoesNotThrow(() -> new Name("12345"));
        assertThrows(IllegalArgumentException.class,
                () -> new Name("123456"),
                ErrorConsts.LONG_CAR_NAME.getFormattedMessage(5));
    }
}
