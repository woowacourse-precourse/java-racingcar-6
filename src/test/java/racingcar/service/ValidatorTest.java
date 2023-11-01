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
}