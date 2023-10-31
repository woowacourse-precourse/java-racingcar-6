package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoundTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private final PrintStream originalOutput = System.out;
    private OutputStream outputCaptor;
    private Round round;
    private Cars cars;

    private String getOuput() {
        return outputCaptor.toString();
    }

    @BeforeEach
    void testInit() {
        outputCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCaptor));

        round = new Round();
        cars = new Cars();
    }

    @AfterEach
    void testCleanUp() {
        System.setOut(originalOutput);
        Console.close();
    }

    @Test
    void 한차수의_실행결과_확인한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    cars.registerCar("pobi,woni");
                    round.start(cars);
                    assertThat(getOuput()).contains("pobi : -", "woni : ");
                },
                MOVING_FORWARD, STOP
        );
    }
}