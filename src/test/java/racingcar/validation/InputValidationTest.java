package racingcar.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputValidationTest {

    private InputValidation inputValidation;

    @BeforeEach
    public void setUp() {
        inputValidation = new InputValidation();
    }

    @Test
    void 자동차_이름_중복_입력() {
        //given
        String userInput = "BMW,BMW,Ford";

        //then
        Assertions.assertThatThrownBy(() -> inputValidation.validateCarName(userInput))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 자동차_이름_하나만_입력() {
        //given
        String userInput = "BMW";

        //then
        Assertions.assertThatThrownBy(() -> inputValidation.validateCarName(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_숫자가_아닌_값_입력() {
        //given
        String userInput = "123abc";

        //then
        Assertions.assertThatThrownBy(() -> inputValidation.validateRound(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_입력() {
        //given
        String userInput = "-1";

        //then
        Assertions.assertThatThrownBy(() -> inputValidation.validateRound(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}