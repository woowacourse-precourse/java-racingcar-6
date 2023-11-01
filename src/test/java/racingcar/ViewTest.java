package racingcar;

import View.InputView;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Fail.fail;


public class ViewTest {

    @Test
    void test_콤마가_포함되지_않은_경우_예외처리() {
        InputView input = new InputView();
        try {
            input.getCarNameError("whas");

            fail("예외가 발생하지 않았습니다");
        } catch (IllegalArgumentException a) {
        }
    }

    @Test
    void test_사용자가_입력한_값이_1보다_작을_경우_예외처리() {
        InputView input = new InputView();
        try {
            input.getTryNumberError(0);

            fail("예외가 발생하지 않았습니다");
        } catch (IllegalArgumentException a) {
        }
    }
}
