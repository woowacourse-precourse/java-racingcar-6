package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationTest {
    @Test
    void checkNameLength_차_이름_길이_5_초과_확인() {
        assertThatThrownBy(() -> InputValidation.checkNameLength("harryyyy"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름은 5자를 넘을 수 없습니다.");
    }

    @Test
    void checkNameLength_차_이름_빈칸_확인() {
        assertThatThrownBy(() -> InputValidation.checkNameLength(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 없는 차가 존재합니다.");
    }

    @Test
    void checkRaceRoundInput_라운드_수_입력_숫자인지_확인() {
        assertThatThrownBy(() -> InputValidation.checkRaceRoundInput("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("라운드 수가 숫자로 입력되지 않았습니다.");
    }

    @Test
    void checkRaceRoundInput_라운드_수_입력_양수인지_확인() {
        assertThatThrownBy(() -> InputValidation.checkRaceRoundInput("-10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("라운드 수는 양수여야 합니다.");
    }
}
