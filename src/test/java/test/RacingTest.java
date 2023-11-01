package test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.validation.InputValidation;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;

public class RacingTest {

    @Test
    void 경주_자동차이름_반점_기준으로_구분() {
        String input = "pobi,woni,jun";
        String[] lst = generateRacersFromNames(input);

        Assertions.assertThat(lst).isEqualTo(new String[]{"pobi", "woni", "jun"});
    }

    @Test
    public void 이름_5글자_초과_검증() {
        InputValidation inputValidation = new InputValidation();
        String invalidName = "jeonsg";

        Assertions.assertThatThrownBy(() -> inputValidation.isNameValid(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 초과할 수 없습니다.");
    }

    @Test
    public void 입력한_횟수_숫자로_변환_불가능_할_때_검증() {
        String input = "abc";
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThatThrownBy(() -> inputView.readTryGame())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 숫자를 입력하세요.");
    }

    private String[] generateRacersFromNames(String input) {
        return input.split(",");
    }

}
