package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.OutputManager;

class OutputManagerTest {
    private static final int MOVING_FORWARD = 4;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void 경주할_자동차_입력요청_메시지_출력() {
        // given
        OutputManager outputManager = new OutputManager();

        // when
        outputManager.printRequestCarNameInputMessage();

        // then
        assertThat(outputStreamCaptor.toString().trim()).contains(OutputManager.REQUEST_CAR_NAME_INPUT);
    }

    @Test
    void 게임_진행_회수_입력요청_메시지_출력() {
        // given
        OutputManager outputManager = new OutputManager();

        // when
        outputManager.printRequestGameCountInputMessage();

        // then
        assertThat(outputStreamCaptor.toString().trim()).contains(OutputManager.REQUEST_GAME_COUNT_INPUT);
    }

    @Test
    void 자동차가_전진한_정도를_출력() {
        // given
        RacingGame racingGame = new RacingGame();
        OutputManager outputManager = new OutputManager();

        Car car1 = Car.createCar("pobi");
        Car car2 = Car.createCar("woni");
        Car car3 = Car.createCar("harry");
        List<Car> cars = List.of(car1, car2, car3);

        for (int i = 0; i < 4; i++) {
            car1.moveOrStop(MOVING_FORWARD);
            car2.moveOrStop(MOVING_FORWARD);
        }
        for (int i = 0; i < 2; i++) {
            car3.moveOrStop(MOVING_FORWARD);
        }
        racingGame.setCars(cars);

        // when
        outputManager.printCarsPosition(racingGame.getAllCarsTrail());

        // then
        assertThat(outputStreamCaptor.toString().trim()).contains("pobi : ----");
        assertThat(outputStreamCaptor.toString().trim()).contains("woni : ----");
        assertThat(outputStreamCaptor.toString().trim()).contains("harry : --");
    }
}
