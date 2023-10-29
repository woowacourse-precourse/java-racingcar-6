package racingcar.utils;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

class InputValidatorTest {

    @Test
    void 다섯_글자_넘는_경우() {
        List<String> carNames = Arrays.asList("다섯자이상의이름");
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateCarNames(carNames);
        });
    }

    @Test
    void 중간에_다섯글자_넘는_경우() {
        List<String> carNames = Arrays.asList("pobi", "다섯글자넘는이름", "jun");
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateCarNames(carNames);
        });
    }

    @Test
    void 컴마_연속_두개() {
        List<String> carNames = Arrays.asList("pobi", "", "jun", "aa");
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateCarNames(carNames);
        });
    }

    @Test
    void NULL_테스트(){
        List<String> carNames = Arrays.asList(null, "", "jun", "aa");
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateCarNames(carNames);
        });
    }

    @Test
    void 중복_이름이_들어오는_경우(){
        List<String> carNames = Arrays.asList("a", "a", "b", "c");
        assertThrows(IllegalArgumentException.class, ()->{
            InputValidator.validateCarNames(carNames);
        });
    }

    @Test
    void 빈_문자열() {
        List<String> carNames = Arrays.asList("");
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateCarNames(carNames);
        });
    }

    @Test
    void 컴마_빈칸_컴마() {
        List<String> carNames = Arrays.asList("pobi", " ", "jun");
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateCarNames(carNames);
        });
    }

    @Test
    void 올바른_입력() {
        List<String> carNames = Arrays.asList("pobi", "jun", "aa");
        assertDoesNotThrow(()->InputValidator.validateCarNames(carNames));
    }


    @Test
    void 시도횟수_정수가_아닌경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateAttemptCount("1.1");
        });
    }

    @Test
    void 시도횟수_0이하_인_경우() {
        assertThrows(IllegalArgumentException.class, ()->{
            InputValidator.validateAttemptCount("-1");
        });
    }

    @Test
    void 시도횟수_숫자가_아닌_경우() {
        assertThrows(IllegalArgumentException.class, ()->{
            InputValidator.validateAttemptCount("다섯");
        });
    }


}