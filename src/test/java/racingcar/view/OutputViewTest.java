package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Camera;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Judgement;
import racingcar.utils.CarListGenerator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    private OutputView outputView;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void beforeEach() {
        outputView = new OutputView();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void displayRequestCarNames() {
        outputView.displayRequestCarNames();
        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(',') 기준으로 구분)\n", outContent.toString());
    }

    @Test
    void displayRequestRaceCount() {
        outputView.displayRequestRaceCount();
        assertEquals("시도할 횟수는 몇회인가요?\n", outContent.toString());
    }

    @Test
    void displayExecutionResult() {
        outputView.displayExecutionResult();
        assertEquals("\n실행 결과\n", outContent.toString());
    }

    @Test
    void displayRacingState() {
        String carNames = "pobi,woni,jun";
        List<Car> carList = CarListGenerator.generateCarList(carNames);
        Cars cars = new Cars(carList);
        Camera camera = new Camera();

        outputView.displayRacingState(camera.captureRaceState(cars));

        String excepted =
                    """
                          pobi :\s
                          woni :\s
                          jun : \n\n""";
        assertEquals(excepted, outContent.toString());
    }

    @Test
    void displayFinalWinners() {
        String carNames = "pobi,woni,jun";
        List<Car> carList = CarListGenerator.generateCarList(carNames);
        Cars cars = new Cars(carList);
        Judgement judgement = new Judgement();

        outputView.displayFinalWinners(judgement.determineWinners(cars));

        String excepted = "최종 우승자 : pobi, woni, jun"; // 아무도 안움직였으므로, 공동 우승
        assertEquals(excepted, outContent.toString());
    }
}
