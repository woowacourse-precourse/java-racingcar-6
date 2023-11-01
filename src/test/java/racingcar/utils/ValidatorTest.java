package racingcar.utils;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    private List<String> carNameList;

    @Test
    void 자동차_이름_길이_5이하() {
        carNameList = Arrays.asList("pobi", "woni", "jun");
        assertDoesNotThrow(() -> Validator.checkCarNameLength(carNameList));
    }

    @Test
    void 자동차_이름_길이_5초과() {
        carNameList = Arrays.asList("pobiii", "woni", "jun");
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.checkCarNameLength(carNameList));
        assertEquals("입력 가능한 자동차의 이름은 5자 이하입니다.", exception.getMessage());
    }

    @Test
    void 자동차_입력_개수_1이상() {
        carNameList = Arrays.asList("pobi");
        assertDoesNotThrow(() -> Validator.checkCarNameCount(carNameList));
        carNameList = Arrays.asList("pobii", "woni", "jun");
        assertDoesNotThrow(() -> Validator.checkCarNameCount(carNameList));
    }

    @Test
    void 자동차_입력_개수_1미만() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.checkCarNameCount(Collections.emptyList()));
        assertEquals("1대 이상의 자동차 이름을 입력해주세요.", exception.getMessage());
    }

    @Test
    void 시도_회수_숫자로_입력() {
        assertEquals(5, Validator.checkDigit("5"));
        assertEquals(50, Validator.checkDigit("50"));
    }

    @Test
    void 시도_회수_숫자가_아닌_값_입력() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Validator.checkDigit("pobi"));
        assertEquals("시도 회수는 숫자여야합니다.", exception.getMessage());
    }

}
