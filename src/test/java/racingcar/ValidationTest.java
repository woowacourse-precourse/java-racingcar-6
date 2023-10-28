package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    @DisplayName("자동차 이름 입력 검증")
    void hasIllegalName() {
        // given
        String legal = "a,bb,ccc,dddd,eeeee";
        String[] legals = legal.split(",");

        String illegal1 = "a,bb,abcdef";
        String[] illegals1 = illegal1.split(",");

        String illegal2 = ",a,b,c,";
        String[] illegals2 = illegal2.split(",");

        String illegal3 = ",,,";
        String[] illegals3 = illegal3.split(",");

        for (String s : illegals3) {
            System.out.println("s = " + s);
        }

        // when then
        Validation.validateCarNames(legals);

        assertThatThrownBy(() -> Validation.validateCarNames(illegals1))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Validation.validateCarNames(illegals2))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Validation.validateCarNames(illegals3))
            .isInstanceOf(IllegalArgumentException.class);
    }
}