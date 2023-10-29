package racingcar.output;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.input.ConsoleInput;
import racingcar.input.Input;
import racingcar.validator.Validator;

class ConsoleOutputWinnerTest extends NsTest {

    Validator validator = new Validator();
    Input consoleInput = new ConsoleInput(validator);
    Output consoleOutput = new ConsoleOutput();

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 우승자_출력1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("DY1,DY2,DY3", "1");
                    assertThat(output()).contains("DY1, DY3");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 우승자_출력2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("DY1,DY2,DY3", "2");
                    assertThat(output()).contains("DY1");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void 우승자_출력3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("DY1,DY2,DY3", "3");
                    assertThat(output()).contains("DY1, DY2, DY3");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 우승자_출력4() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("DY1,DY2,DY3", "3");
                    assertThat(output()).contains("DY1, DY2, DY3");
                },
                STOP, STOP, STOP,
                STOP, STOP, STOP,
                STOP, STOP, STOP
        );
    }

    @Override
    protected void runMain() {
        List<Car> carList = consoleInput.receiveCarNamesAndMakeList();
        int executionCount = consoleInput.receiveTotalCountOfExecution();

        for (int i = 0; i < executionCount; i++) {
            carList.forEach(car -> car.moveForward());
        }

        consoleOutput.printWinner(carList);
    }
}