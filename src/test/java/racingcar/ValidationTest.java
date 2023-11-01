package racingcar;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.validation.CustomInputValidation.*;


import org.junit.jupiter.api.Test;
class ValidationTest {
    @Test
    void 차_두대_이상() {
        assertThatThrownBy(() -> numOfCars(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차는 두 대 이상 입력해야 합니다.");
    }

    @Test
    void 다섯글자_이하_입력() {
        String[] names = {"Antonio, Sophia, Jack"};
        assertThatThrownBy(() -> carNameLength(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차의 이름은 5글자 이하입니다.");
    }

    @Test
    void 유효한_정수_입력() {
        assertThatThrownBy(() -> parseAndValidateInteger("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효한 정수가 아닙니다.");
    }

    @Test
    void 양수_입력() {
        assertThatThrownBy(() -> isPositive(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수를 입력해야 합니다.");
    }

}