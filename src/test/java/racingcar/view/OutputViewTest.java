package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.enums.Common;
import racingcar.model.Cars;
import racingcar.model.Winners;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private PrintStream standardOut;
    private OutputStream captor;
    private static final int MOVE_FORWARD = Common.STANDARD_NUMBER.getIntValue();
    private static final int STOP = Common.STANDARD_NUMBER.getIntValue() - 1;

    private Cars cars;
    private Winners winners;

    @BeforeEach
    protected final void init() {
        Cars cars = new Cars("isaac,han");

        assertRandomNumberInRangeTest(() -> {
            cars.everyCarMoveForwardByRandom();
            cars.everyCarMoveForwardByRandom();

        }, MOVE_FORWARD, STOP, MOVE_FORWARD, STOP);

        winners = new Winners(cars);

        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @Test
    void printCarNameInputMessage_test() {
        OutputView.printCarNameInputMessage();
        assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void printNumberOfAttemptsInputMessage_test() {
        OutputView.printNumberOfAttemptsInputMessage();
        assertThat(output()).contains("시도할 회수는 몇회인가요?");
    }

    @Test
    void printPlayResultMessage_test() {
        OutputView.printPlayResultMessage();
        assertThat(output()).contains("실행 결과");
    }

    @Test
    void printPlayResult_test() {
        OutputView.printPlayResult(cars.getCars());
        assertThat(output()).contains("isaac : --", "han :");
    }

    @Test
    void printWinners_test() {
        OutputView.printWinners(winners.getWinnersNames());
        assertThat(output()).contains("최종 우승자 : isaac");
    }
}