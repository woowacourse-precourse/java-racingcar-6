package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.CarModel;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputViewTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 실행_결과_메세지_출력() {
        OutputView.printResult();
        assertEquals("\n실행 결과\n", outputStreamCaptor.toString());
    }

    @Test
    void 단일_레이스_결과_출력() {
        CarModel[] testCars = new CarModel[2];

        testCars[0] = new CarModel("pobi");
        testCars[0].move();
        testCars[0].move();
        testCars[1] = new CarModel("woni");
        testCars[1].move();

        OutputView.printGameResult(testCars);

        assertEquals("pobi : --\nwoni : -\n\n", outputStreamCaptor.toString());
    }

    @Test
    void 우승자_출력() {
        String[] winnerTestCase1 = {"pobi", "woni"};

        OutputView.printWinners(winnerTestCase1);
        assertEquals("최종 우승자 : pobi, woni\n", outputStreamCaptor.toString());
    }
}