package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    private Validator validator = new Validator();
    @Test
    @DisplayName("이름의 길이가 5보다 클 경우 예외처리 테스트")
    void validate_Name_When_Over_Length() {
        List<String> testNameList = Arrays.asList("pobiiii","woni");
        assertThatThrownBy(() -> validator.validateNameLength(testNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 길이가 5보다 큽니다.");
    }

    @Test
    @DisplayName("이름에 공백이 존재할 경우 예외처리 테스트")
    void validate_Name_When_Space_Name() {
        List<String> testNameList = Arrays.asList("pob i","woni");
        assertThatThrownBy(() -> validator.validateNameSpace(testNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름에 공백이 존재합니다.");
    }

    @Test
    @DisplayName("이름이 중복될 경우에 대한 예외처리 테스트")
    void validate_Name_When_Duplicate_Name() {
        List<String> testNameList = Arrays.asList("pobi","pobi");
        assertThatThrownBy(() -> validator.validateNameDuplication(testNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름이 존재합니다.");
    }
    @Test
    @DisplayName("시도 횟수가 0일 경우에 대한 예외처리 테스트")
    void validate_Trial_Num_When_Zero() {
        String testTrialNumber = "0";
        assertThatThrownBy(() -> validator.validateZeroTrialNumber(testTrialNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 0보다 커야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수가 문자일 경우에 대한 예외처리 테스트")
    void validate_Trial_Num_When_Character() {
        String testTrialNumber = "a";
        assertThatThrownBy(() -> validator.validateNonIntTrialNumber(testTrialNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("반복 횟수는 정수 혹은 양수만 가능합니다.");
    }
    @Test
    @DisplayName("시도 횟수가 음수일 경우에 대한 예외처리 테스트")
    void validate_Trial_Num_When_Negative() {
        String testTrialNumber = "-1";
        assertThatThrownBy(() -> validator.validateNonIntTrialNumber(testTrialNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("반복 횟수는 정수 혹은 양수만 가능합니다.");
    }
}