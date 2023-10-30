package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.TestNumberGenerator;

class RacingControllerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void 모든시도횟수_진행후_결과출력_테스트() {
        Car car1 = new Car("pobi", new TestNumberGenerator(4));
        Car car2 = new Car("woni", new TestNumberGenerator(1));
        Car car3 = new Car("jun", new TestNumberGenerator(3));
        List<Car> cars = Arrays.asList(car1, car2, car3);
        int attemptCount = 5;
        RacingController racingController = new RacingController();
        racingController.playGame(cars, attemptCount);

        String expectedOutput = "실행 결과\n" + "pobi : -\n" + "woni : \n" + "jun : \n" + "\n" +
                "pobi : --\n" + "woni : \n" + "jun : \n" + "\n" + "pobi : ---\n" + "woni : \n" + "jun : \n" + "\n" +
                "pobi : ----\n" + "woni : \n" + "jun : \n" + "\n" + "pobi : -----\n" + "woni : \n" + "jun : \n" +
                "\n" + "최종 우승자 : pobi\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }
}
