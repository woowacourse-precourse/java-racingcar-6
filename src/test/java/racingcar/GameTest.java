package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.input.ConsoleInput;
import racingcar.output.ConsoleOutput;
import racingcar.validator.Validator;

class GameTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String CAR_NAME_INPUT = "DY1,DY2,DY3,DY4";
    private static final String CAR_NAME_INPUT_EXCEPTION = "DY1,DY2,DY345321";
    private static final String EXECUTION_COUNT_INPUT = "5";
    private static final String EXECUTION_COUNT_INPUT_EXCEPTION = "ab";


    @Test
    void 게임_진행1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(CAR_NAME_INPUT, EXECUTION_COUNT_INPUT);
                    assertThat(output()).contains(
                            "DY1 : -\r\nDY2 : \r\nDY3 : -\r\nDY4 : ",
                            "DY1 : -\r\nDY2 : -\r\nDY3 : -\r\nDY4 : -",
                            "DY1 : --\r\nDY2 : -\r\nDY3 : --\r\nDY4 : -",
                            "DY1 : --\r\nDY2 : --\r\nDY3 : --\r\nDY4 : --",
                            "DY1 : ---\r\nDY2 : --\r\nDY3 : ---\r\nDY4 : --",
                            "최종 우승자 : DY1, DY3");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 게임_진행2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(CAR_NAME_INPUT, EXECUTION_COUNT_INPUT);
                    assertThat(output()).contains(
                            "DY1 : -\r\nDY2 : -\r\nDY3 : -\r\nDY4 : -",
                            "DY1 : --\r\nDY2 : --\r\nDY3 : --\r\nDY4 : --",
                            "DY1 : ---\r\nDY2 : ---\r\nDY3 : ---\r\nDY4 : ---",
                            "DY1 : ----\r\nDY2 : ----\r\nDY3 : ----\r\nDY4 : ----",
                            "DY1 : -----\r\nDY2 : -----\r\nDY3 : -----\r\nDY4 : -----",
                            "최종 우승자 : DY1, DY2, DY3, DY4");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 게임_진행3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(CAR_NAME_INPUT, EXECUTION_COUNT_INPUT);
                    assertThat(output()).contains(
                            "DY1 : \r\nDY2 : \r\nDY3 : \r\nDY4 : ",
                            "DY1 : \r\nDY2 : \r\nDY3 : \r\nDY4 : ",
                            "DY1 : \r\nDY2 : \r\nDY3 : \r\nDY4 : ",
                            "DY1 : \r\nDY2 : \r\nDY3 : \r\nDY4 : ",
                            "DY1 : \r\nDY2 : \r\nDY3 : \r\nDY4 : ",
                            "최종 우승자 : DY1, DY2, DY3, DY4");
                },
                STOP, STOP, STOP, STOP,
                STOP, STOP, STOP, STOP,
                STOP, STOP, STOP, STOP,
                STOP, STOP, STOP, STOP,
                STOP, STOP, STOP, STOP
        );
    }

    @Test
    void 게임_진행_예외1() {
        assertThatThrownBy(() ->
                runException(CAR_NAME_INPUT_EXCEPTION, EXECUTION_COUNT_INPUT_EXCEPTION))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Game game = new Game(new ConsoleInput(new Validator()), new ConsoleOutput());
        game.play();
    }
}