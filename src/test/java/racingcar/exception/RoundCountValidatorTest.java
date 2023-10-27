package racingcar.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundCountValidatorTest {

    @Test
    void 입력받은_레이싱_경기_횟수_숫자_성공() {
        String input = "6";
        RoundCountValidator.validate(input);
    }

    @Test
    void 입력받은_레이싱_경기_횟수_숫자가_아님_예외() {
        String input = "asd";
        assertThatThrownBy(() -> RoundCountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_레이싱_경기_횟수_공백_예외() {
        String input = "";
        assertThatThrownBy(() -> RoundCountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_레이싱_경기_횟수_공백_포함_예외() {
        String input = " 12";
        assertThatThrownBy(() -> RoundCountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_레이싱_경기_횟수_숫자로_변환시_0이면_예외() {
        String input = "0";
        assertThatThrownBy(() -> RoundCountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_레이싱_경기_횟수_음수_예외() {
        String input = "-612";
        assertThatThrownBy(() -> RoundCountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_레이싱_경기_횟수_int_형_최대값_넘으면_예외() {
        String input = "3333333333";
        assertThatThrownBy(() -> RoundCountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_레이싱_경기_횟수_소수점_예외() {
        String input = "6.2";
        assertThatThrownBy(() -> RoundCountValidator.validate(input))
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
