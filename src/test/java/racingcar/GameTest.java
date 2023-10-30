package racingcar;

import game.Game;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.RacingCarTestConstants.MOVING_FORWARD;
import static racingcar.RacingCarTestConstants.STOP;

public class GameTest {

    @Test
    void start_게임_시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    String carsInput = "car1,car2,car3";
                    String frequencyInput = "1";

                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    System.setOut(new PrintStream(outputStream));
                    System.setIn(new ByteArrayInputStream((carsInput + System.lineSeparator() + frequencyInput).getBytes()));


                    Game game = new Game();
                    game.start();

                    String captured = outputStream.toString().trim();
                    assertThat(captured).contains("car1 : -", "car2 : -", "car3 : ", "최종 우승자 : car1, car2");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }
}
