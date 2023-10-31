package racingcar.Controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import racingcar.Global.Constants;
import racingcar.View.InputView;
import racingcar.View.OutputView;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ControllerTest {

    static Controller controller;

    @Test
    @Order(1)
    void 게임_초기화() {
        System.setIn(new ByteArrayInputStream("pobi\n4".getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        controller = new Controller(new InputView(), new OutputView());
        assertThat(out.toString()).contains(Constants.getCarsNameState, Constants.getGameStageNumberState);
    }

    @Test
    @Order(2)
    void 게임_실행() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertRandomNumberInRangeTest(
                () -> {
                    controller.run();
                    assertThat(out.toString()).contains("pobi : ", "최종 우승자 : pobi");
                },
                3, 3, 3, 3
        );
    }
}