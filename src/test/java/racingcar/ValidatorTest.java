package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    @DisplayName("부적절한 commma 포함 문자열 예외 발생 테스트")
    void isSplitByCommaTest() {
        List<String> testCaseList = Arrays.asList(new String[]{",,", ",", " ", "a", ",b", "a,b,"});
        for (String testCase : testCaseList) {
            assertThatThrownBy(() -> validator.validate(testCase, 0));
        }
    }

    @Test
    @DisplayName("부적절한 자동차의 이름 예외 발생 테스트")
    void isValidLength() {
        List<String> testCaseList = Arrays.asList(new String[]{" ,a", " , ", "abc,pobito"});
        for (String testCase : testCaseList) {
            assertThatThrownBy(() -> validator.validate(testCase, 0));
        }
    }

    @Test
    @DisplayName("부적절한 시도 회수 예외 발생 테스트")
    void isValidNumber() {
        List<String> testCaseList = Arrays.asList(new String[]{"9999999999999999999999999999", "123a"});
        for (String testCase : testCaseList) {
            assertThatThrownBy(() -> validator.validate(testCase, 1));
        }
    }
}