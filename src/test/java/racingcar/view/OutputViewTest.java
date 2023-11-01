package racingcar.view;

import static racingcar.view.OutputMessageType.RESULT_MESSAGE;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.car.CarManager;
import racingcar.model.car.RacingCar;

@DisplayName("[Output View]")
class OutputViewTest {

    private final OutputView outputView = OutputView.getInstance();

    List<Car> cars = List.of(
            new RacingCar("t1", 1),
            new RacingCar("t0", 3),
            new RacingCar("t2", 2),
            new RacingCar("t3", 3));

    PrintStream originalOut;

    ByteArrayOutputStream contentOut;

    @BeforeEach
    void setup() {
        this.originalOut = System.out;
        this.contentOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(contentOut));
    }

    @Test
    @DisplayName("실행 결과 메세지 출력 테스트")
    public void printResultMessageTest() {
        outputView.printResultMessage();
        System.setOut(originalOut);

        Assertions.assertEquals("\n" + RESULT_MESSAGE.getMessage() + "\n", contentOut.toString());
    }

    @Test
    @DisplayName("각 게임 결과 메세지 출력 테스트")
    public void printSingleRaceResultTest() {
        final String output = "t1 : -" + "\n" +
                "t0 : ---" + "\n" +
                "t2 : --" + "\n" +
                "t3 : ---" + "\n";

        outputView.printSingleRaceResult(this.cars);
        System.setOut(originalOut);

        Assertions.assertEquals(output + "\n", contentOut.toString() );
    }

    @Test
    @DisplayName("최종 게임 결과 메세지 출력 테스트")
    public void printFinalRaceResultTest() {
        final String output = "최종 우승자 : t0, t3" ;
        outputView.printFinalRaceResult(new CarManager(this.cars).getWinner());
        System.setOut(originalOut);

        Assertions.assertEquals(output + "\n", contentOut.toString());

    }
}