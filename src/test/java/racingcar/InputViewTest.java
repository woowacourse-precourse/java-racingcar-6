package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

public class InputViewTest {
    @Test
    void 경기_참여_자동차_입력_테스트() {
        String input = InputView.readCarName();
        String[] inputs = input.split(",");

        for(int i = 0 ; i < inputs.length; i++){
            Assertions.assertTrue(inputs[i].length()<=5);
            Assertions.assertTrue(inputs[i]!=null);
        }

    }

}
