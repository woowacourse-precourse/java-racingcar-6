package racingcar.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidationUtilTest {
    @Test
    public void 검증로직_이름_입력_초과_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtil.validateCarName("123456");
        });
    }

    @Test
    public void 검증로직_이름_입력_만족_테스트() {
        assertDoesNotThrow(() -> {
            ValidationUtil.validateCarName("12345");
        });
    }

    @Test
    public void 검증로직_이름_입력_부족_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtil.validateCarName("");
        });
    }

    @Test
    public void 검증로직_시도_횟수_입력_부족_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtil.validateAttemptNumber(0);
        });
    }

    @Test
    public void 검증로직_시도_횟수_입력_만족_테스트() {
        assertDoesNotThrow(() -> {
            ValidationUtil.validateAttemptNumber(1);
        });
    }

    @Test
    public void 검증로직_시도_입력_문자() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtil.validateIsNumeric("a");
        });
    }
    @Test
    public void 검증로직_시도_입력_공백() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtil.validateIsNumeric(" ");
        });
    }

    @Test
    public void 검증로직_시도_입력_숫자() {
        assertDoesNotThrow(() -> {
            ValidationUtil.validateIsNumeric("1");
        });
    }

    @Test
    public void 검증로직_자동차_이름_입력_부족_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtil.validateCarNames(new String[] {});
        });
    }

    @Test
    public void 검증로직_자동차_이름_입력_만족_테스트() {
        assertDoesNotThrow(() -> {
            ValidationUtil.validateCarNames(new String[] {"12345"});
        });
    }
}