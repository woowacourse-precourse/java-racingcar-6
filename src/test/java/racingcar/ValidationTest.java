package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    @DisplayName("자동차 이름 입력 검증")
    void hasIllegalName() {
        // given
        String legal = "a,bb,ccc,dddd,eeeee";
        List<String> legals = Arrays.asList(legal.split(","));

        String illegal1 = "a,bb,abcdef";
        List<String> illegals1 = Arrays.asList(illegal1.split(","));

        String illegal2 = ",a,b,c,";
        List<String> illegals2 = Arrays.asList(illegal2.split(","));

        String illegal3 = ",,,";
        List<String> illegals3 = Arrays.asList(illegal3.split(","));

        for (String s : illegals3) {
            System.out.println("s = " + s);
        }

        // when - then
        Validation.validateCarNames(legals);

        assertThatThrownBy(() -> Validation.validateCarNames(illegals1))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Validation.validateCarNames(illegals2))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Validation.validateCarNames(illegals3))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 횟수 입력 검증")
    void validateGameCount() {
        // given
        String legal = "12";
        String illegal1 = "0";
        String illegal2 = "-1";
        String illegal3 = "123a";

        // when - then
        Validation.validateGameCount(legal);

        assertThatThrownBy(() -> Validation.validateGameCount(illegal1))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Validation.validateGameCount(illegal2))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Validation.validateGameCount(illegal3))
            .isInstanceOf(IllegalArgumentException.class);
    }
}