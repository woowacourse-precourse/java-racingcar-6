package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputValidatorTest {

    @Test
    @DisplayName("같은 이름 중복 처리")
    void test1() {
        List<String> cars = List.of("asdf", "asdf");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateDuplicate(cars))
                .withMessage("중복이 존재합니다.");
    }

    @Test
    @DisplayName("5글자 초과 문자 검사")
    void test2() {
        List<String> cars = List.of("asdf", "asdfasdf");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateNameLength(cars))
                .withMessage("이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("2개 이상의 경주할 자동차 검사")
    void test3() {
        List<String> cars = List.of("asdf");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateCarNamesSize(cars))
                .withMessage("2개 이상 입력해 주세요");
    }

    @Test
    @DisplayName("쉼표 구분 확인")
    void test4() {
        String string = "asdf wer wer";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateRegex(string))
                .withMessage("쉼표로 구분되어야 합니다.");
    }

    @Test
    @DisplayName("시도 회수가 숫자로 입력되었는지 확인")
    void test5() {
        String string = "1, asdf, 3";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateDigit(string))
                .withMessage("숫자만 입력 가능합니다.");
    }
}
