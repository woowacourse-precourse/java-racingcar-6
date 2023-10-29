package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

class ControllerTest {
    private Controller controller = new Controller(new InputView());

    @Test
    void 사용자_입력으로_경주_생성() {
        //given
        String inputString = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        //when
        controller.run();
        //then
        //no exception thrown
    }

}