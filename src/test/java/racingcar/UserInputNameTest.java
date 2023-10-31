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
            System.out.println("이름 형식 5글자 이상 : " + e.getMessage());
            Assertions.assertEquals(Message.NAME_INPUT_LENGTH_ERROR, e.getMessage());
        }
    }

    @Test
    void 이름_형식_쉼표_두개_연속_들어간_경우() {
        String input_names = "first,,second";

        try {
            Controller.convertStringToArrayList(input_names);
        } catch (IllegalArgumentException e) {
            System.out.println("이름 형식에 쉽표가 두개 연속으로 들어간 경우 : " + e.getMessage());
            Assertions.assertEquals(Message.NAME_INPUT_NULL_ERROR, e.getMessage());
        }
    }

    @Test
    void 이름_형식_아무_입력이_없는_경우() {
        String input_names = "";

        try {
            Controller.convertStringToArrayList(input_names);
        } catch (IllegalArgumentException e) {
            System.out.println("이름 형식에 아무런 입력이 없는 경우 : " + e.getMessage());
            Assertions.assertEquals(Message.NAME_INPUT_NULL_ERROR, e.getMessage());
        }
    }
}
