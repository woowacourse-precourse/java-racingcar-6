package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.Validator;

public class ValidatorTest {

    @Test
    void 비어있는_입력_예외테스트() {
        assertThatThrownBy(()-> Validator.validateEmpty(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input can't be empty.");
    }

    @Test
    @DisplayName("0이하의 수 입력 예외테스트")
    void 이하의_수_입력_예외테스트() {
        assertThatThrownBy(()-> Validator.validatePositive("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input should be more than zero.");
    }

    @Test
    void 정수가_아닌_수_입력_예외테스트() {
        assertThatThrownBy(()-> Validator.validateInteger("1.34"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input should be integer.");
    }

    @Test
    void 길이가_6자_이상_이름_입력_예외테스트() {
        assertThatThrownBy(()-> Validator.validateLength("wwwwww"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Car names should be less than five character.");
    }

    @Test
    void 중복된_이름_입력_예외테스트() {
        assertThatThrownBy(() -> Validator.validateDuplication(Arrays.asList("pobi","pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Each car has to have unique name.");
    }
}
