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

class ConsoleOutputExecutionResultTest extends NsTest {

    Validator defaultValidator = new Validator();
    Input consoleInput = new ConsoleInput(defaultValidator);
    Output consoleOutput = new ConsoleOutput();

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 차수별_실행_결과_출력1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("DY1,DY2", "1");
                    //output()의 trim()때문에 뒷 공백 사라짐
                    assertThat(output()).contains("DY1 : -\r\nDY2 :");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 차수별_실행_결과_출력2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("DY1,DY2", "2");
                    assertThat(output()).contains(
                            "DY1 : -\r\nDY2 : -",
                            "DY1 : --\r\nDY2 : -"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 차수별_실행_결과_출력3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("DY1,DY2", "3");
                    assertThat(output()).contains(
                            "DY1 : -\r\nDY2 : ",
                            "DY1 : --\r\nDY2 : ",
                            "DY1 : ---\r\nDY2 :"
                    );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP, MOVING_FORWARD, STOP
        );
    }

    @Override
    protected void runMain() {
        List<Car> carList = consoleInput.receiveCarNamesAndMakeList();
        int executionCount = consoleInput.receiveTotalCountOfExecution();

        for (int i = 0; i < executionCount; i++) {
            carList.forEach(car -> car.moveForward());
            consoleOutput.printExecutionResult(carList);
        }
    }
}