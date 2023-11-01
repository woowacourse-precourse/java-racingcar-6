package racingcar.Exception;


import org.junit.jupiter.api.Test;
import racingcar.View.InputView;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputException {

    @Test
    void 자동차_이름_예외1_자동차_이름_길이가_6이상일_경우_예외발생() {

        String input = "pony,inValidName";
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.checkCarsNameValidation(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 자동차_이름_예외2_자동차_이름_길이가_0일_경우_예외발생() {

        String input = "pony,,aaa";
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.checkCarsNameValidation(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 자동차_이름_예외3_입력이_비어있는_경우_예외발생() {

        String input = "";
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.checkCarsNameValidation(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 자동차_이름_예외4_자동차_이름이_공백일_경우_예외발생() {

        String input = "     ,aaa";
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.checkCarsNameValidation(input))
                .isInstanceOf(IllegalArgumentException.class);

    }


    @Test
    void 시도_회수_예외1_숫자가_아닌_값이_입력될_경우_예외발생() {

        String input = "not";
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.checkTryCountValidation(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 시도_회수_예외2_음수가_입력될_경우_예외발생() {
        String input = "-1";
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.checkTryCountValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_회수_예외3_Integer_범위_이상의_값이_입력될_경우_예외발생() {
        String input = "2147483648";
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.checkTryCountValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_회수_예외4_입력이_비어있는_경우_예외발생() {

        String input = "";
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.checkTryCountValidation(input))
                .isInstanceOf(IllegalArgumentException.class);

    }


}

