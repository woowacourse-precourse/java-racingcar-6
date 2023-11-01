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

}

