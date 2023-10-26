package racingcar.domian;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {
    @Test
    void 입력받은_레이싱_경기_횟수_숫자_성공() {
        String input = "6";
        int result = Integer.parseInt(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 입력받은_레이싱_경기_횟수_숫자가_아님_예외() {
        String input = "asd";
        assertThatThrownBy(() -> Integer.parseInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_레이싱_경기_횟수_공백_예외() {
        String input = "";
        assertThatThrownBy(() -> Integer.parseInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_레이싱_경기_횟수_공백_포함_예외() {
        String input = " 12";
        assertThatThrownBy(() -> Integer.parseInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_레이싱_경기_횟수_음수_예외() {
        String input = "-612";
        assertThatThrownBy(() -> Integer.parseInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_레이싱_경기_횟수_숫자로_변환시_0이면_예외() {
        String input = "0";
        assertThatThrownBy(() -> Integer.parseInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_레이싱_경기_횟수_int_형_최대값_넘으면_예외() {
        String input = "3333333333";
        assertThatThrownBy(() -> Integer.parseInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * NumberFormatException 를 캐치해서 IllegalArgumentException 를 발생
     */
    @Test
    void 문자열_소수점을_숫자로_변환_예외() {
        String input = "6.2";
        assertThatThrownBy(() -> Integer.parseInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /*
    @Test
    void 문자열_메모리_초과_예외() {
        String input = "";
        for (int i = 0; i < 1000; i++)  {
            input += "111111111111111111111111";
        }

        String finalString = input.toString();
        assertThatThrownBy(() -> Integer.parseInt(finalString))
                .isInstanceOf(OutOfMemoryError.class);
    }
     */
}
