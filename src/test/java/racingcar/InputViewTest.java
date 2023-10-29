package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

public class InputViewTest {


    @AfterEach
    void setUp() {
        Console.close();
    }

    @Test
    void 시도_횟수_입력_테스트() {

        ByteArrayInputStream fakeInput = new ByteArrayInputStream("5".getBytes());
        System.setIn(fakeInput);

        String input = InputView.readTryNumber();

        Assertions.assertTrue(input != null);

    }


    @Test
    void 경기_참여_자동차_입력_테스트() {
        ByteArrayInputStream fakeInput = new ByteArrayInputStream("pobi,junhy,hello".getBytes());
        System.setIn(fakeInput);

        String input = InputView.readCarName();
        String[] inputs = input.split(",");

        for (int i = 0; i < inputs.length; i++) {
            Assertions.assertTrue(inputs[i].length() <= 5);
            Assertions.assertTrue(inputs[i] != null);
        }
    }

    @Test
    void 자동차_입력_검증_테스트() {
        ByteArrayInputStream fakeInput = new ByteArrayInputStream("\n".getBytes());
        System.setIn(fakeInput);

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputView.readCarName();
        });

        Assertions.assertEquals("[ERROR] 공백이 입력되었습니다.", exception.getMessage());

    }

    @Test
    void 시도_횟수_입력_음수_검증_테스트() {
        ByteArrayInputStream fakeInput = new ByteArrayInputStream("-1".getBytes());
        System.setIn(fakeInput);
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputView.readTryNumber();
        });
        Assertions.assertEquals("[ERROR] 음수가 입력되었습니다.", exception.getMessage());
    }


}
