package racingcar.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.User;
import racingcar.view.InputFormView;

public class InputIntegrationTest {
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }
    @Test
    void 입력을_요구하고_입력을_받는다() {
        User user = new User(){
            @Override
            protected String readCarsFromConsole() {
                return "pobi,woni";
            }

            @Override
            protected int readTryNumFromConsole() {
                return 5;
            }
        };

        InputFormView.viewCarInputForm();
        user.readCarInput();

        InputFormView.viewTryNumInputForm();
        user.readTryNumInput();

        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n시도할 회수는 몇회인가요?\n", outputMessage.toString());
        assertEquals("pobi,woni", user.getCarNames());
        assertEquals(5, user.getTryNum());
    }
}
