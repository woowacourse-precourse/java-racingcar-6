package racingcar.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionTest {
    private static Exception exception;

    @BeforeAll()
    static void Exception_객체_생성() {
        exception = new Exception();
    }

    @Test()
    void 입력이_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            exception.isNameNull(null);
        });
    }

    @Test()
    void 입력이_빈_문자열_일_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            exception.isNameNull("");
        });
    }

    @Test()
    void 입력이_공백_일_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            exception.isNameNull(" ");
        });
    }

    @Test()
    void 이름이_5자일_경우_ok() {
        exception.isNameInRange("abcde");
    }

    @Test()
    void 이름이_6자일_경우_no() {
        assertThrows(IllegalArgumentException.class, () -> {
            exception.isNameInRange("abcdef");
        });
    }

    @Test()
    void 시도_입력이_null인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            exception.isInteger(null);
        });
    }

    @Test()
    void 시도_입력이_빈_문자열일_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            exception.isInteger("");
        });
    }

    @Test()
    void 시도_입력이_공백일_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            exception.isInteger(" ");
        });
    }

    @Test()
    void 시도_입력이_문자인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            exception.isInteger("string");
        });
    }

    @Test()
    void 시도_입력이_소수점이_포함될_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            exception.isInteger("1.2");
        });
    }

    @Test()
    void 숫자가_1일_경우_ok() {
        exception.isGreaterThanZero(1);
    }

    @Test()
    void 숫자가_0일_경우_no() {
        assertThrows(IllegalArgumentException.class, () -> {
            exception.isGreaterThanZero(0);
        });
    }

    @Test()
    void 숫자가_음수일_경우_no() {
        assertThrows(IllegalArgumentException.class, () -> {
            exception.isGreaterThanZero(-1);
        });
    }
}