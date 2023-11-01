package racingcar.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationTest {

    private Validation validation;

    @BeforeEach
    void 초기세팅() {
        validation = new Validation();
    }

    @Test
    void 횟수_입력이_숫자여야_한다() {
        assertDoesNotThrow(() -> validation.isNumeric("123"));
    }

    @Test
    void 횟수_입력에_문자가_섞이면_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> validation.isNumeric("12a3"));
    }

    @Test
    void 자동차리스트는_최소2개여야_한다() {
        List<String> validNames = List.of("car1", "car2");
        assertDoesNotThrow(() -> validation.checkNameListSize(validNames));
    }

    @Test
    void 자동차리스트에_자동차가_1개라면_예외처리() {
        List<String> invalidNames = List.of("car1");
        assertThrows(IllegalArgumentException.class, () -> validation.checkNameListSize(invalidNames));
    }

    @Test
    void 자동차_이름은_5자이하여야_한다() {
        assertDoesNotThrow(() -> validation.checkName("car1"));
    }

    @Test
    void 자동차_이름이_6자이상일때_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> validation.checkName("verylongname"));
    }

    @Test
    void 플레이횟수는_숫자이고_1이상이여야_한다() {
        assertDoesNotThrow(() -> validation.checkPlayCount(3));
    }

    @Test
    void 플레이숫자는_0이하일_수_없다() {
        assertThrows(IllegalArgumentException.class, () -> validation.checkPlayCount(-1));
    }

    @Test
    void 자동차의_이름이_중복되서_경주할_수_없다() {
        List<String> uniqueNames = List.of("car1", "car2");
        assertDoesNotThrow(() -> validation.hasDuplication(uniqueNames));
    }

    @Test
    void 자동차_이름이_중복되면_예외처리() {
        List<String> duplicatedNames = List.of("car1", "car1");
        assertThrows(IllegalArgumentException.class, () -> validation.hasDuplication(duplicatedNames));
    }
}
