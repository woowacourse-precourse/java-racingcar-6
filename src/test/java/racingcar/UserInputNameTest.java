package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.controller.Controller;
import racingcar.view.Message;

import java.util.ArrayList;

public class UserInputNameTest {
    @Test
    void 이름_형식_정상적_입력() {
        String input_names = "kim, lee, park";

        ArrayList<String> output_names = Controller.convertStringToArrayList(input_names);

        org.assertj.core.api.Assertions.assertThat(output_names).containsExactly("kim", "lee", "park");
    }

    @Test
    void 이름_형식_5글자_이상() {
        String input_names = "overfivelenght";

        try {
            Controller.convertStringToArrayList(input_names);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(Message.NAME_INPUT_LENGTH_ERROR, e.getMessage());
        }
    }
}
