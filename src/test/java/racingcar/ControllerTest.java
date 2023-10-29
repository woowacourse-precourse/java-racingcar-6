package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

class ControllerTest {
    private Controller controller = new Controller(new InputView());

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    void 사용자_입력으로_경주_생성() {
        //given
        String inputString = "pobi,woni,jun\n5\n";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        //when
        controller.run();
        //then
        //no exception thrown
    }

}