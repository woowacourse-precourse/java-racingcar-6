package racingcar.game.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.entity.Car;

public class RacingGameResponderTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream sysOut = System.out;

    @Test
    void testInformGameProcess_ConsecutiveCall() {
        System.setOut(new PrintStream(outContent));
        RacingGameResponder racingGameResponderTester = new RacingGameResponder();
        racingGameResponderTester.informGameProcess(
                List.of(
                        initializeCarForTesting("aaa", 4),
                        initializeCarForTesting("bbb", 2),
                        initializeCarForTesting("234", 1),
                        initializeCarForTesting("hw", 5)
                )
        );
        racingGameResponderTester.informGameProcess(
                List.of(
                        initializeCarForTesting("aaa", 4),
                        initializeCarForTesting("bbb", 2),
                        initializeCarForTesting("234", 1),
                        initializeCarForTesting("hw", 5)
                )
        );
        assertEquals("\n"
                + "실행 결과\n"
                + "aaa : ----\n"
                + "bbb : --\n"
                + "234 : -\n"
                + "hw : -----\n"
                + "\n"
                + "\n"
                + "aaa : ----\n"
                + "bbb : --\n"
                + "234 : -\n"
                + "hw : -----\n"
                + "\n", outContent.toString());
        System.setOut(sysOut);
    }

    Car initializeCarForTesting(String name, int pos) {
        Car car = new Car(name);
        for (int i = 0; i < pos; i++) {
            car.proceedSingleUnit();
        }
        return car;
    }

    @Test
    void testInformGameResult() {
        System.setOut(new PrintStream(outContent));
        RacingGameResponder racingGameResponderTester = new RacingGameResponder();
        racingGameResponderTester.informGameResult(List.of(
                "aaa", "bbb", "ccc"
        ));
        assertEquals("최종 우승자 : aaa, bbb, ccc\n", outContent.toString());
        System.setOut(sysOut);
    }
}
