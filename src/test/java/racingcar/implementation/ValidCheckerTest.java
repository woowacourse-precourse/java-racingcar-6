package racingcar.implementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.implementation.ValidChecker;

import java.util.Arrays;
import java.util.List;

public class ValidCheckerTest {
    private static ValidChecker checker;

    @BeforeAll
    static void before() {
        checker = new ValidChecker();
    }

    @Test
    void 자동차_이름_중복_입력() {
        checker.isDuplicated("test");
        Assertions.assertThrows(IllegalArgumentException.class, () -> checker.isDuplicated("test"));
    }

    @Test
    void 자동차_이름_넌알파베틱_입력() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> checker.isAlphabetic("a;rw2"));
    }

    @Test
    void 자동차_이름_다섯_글자_이상_입력() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> checker.atMostFiveWords("abcdefg"));
    }

    @Test
    void 시도_횟수_숫자_외_입력() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> checker.numberOfTryCheck("d"));
    }
}
