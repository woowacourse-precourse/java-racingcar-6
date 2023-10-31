package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.InputController;
import racingcar.model.domain.Car;
import racingcar.model.service.InputService;
import racingcar.view.OutputView;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private RaceGame raceGame;
    private Car car;
    private InputController inputController;
    private OutputView outputView;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @BeforeEach
    void setup() {
        outputView = new OutputView();
        car = new Car();
        InputService inputService = new InputService();
        inputController = new InputController(inputService);
        raceGame = new RaceGame(outputView, car, inputController);
    }

    @Test
    void 시도_횟수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 전진_후진을_랜덤하게_했을때_출력문() {
        // given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        Map<String, Integer> map = new HashMap<>();
        map.put("pobi", 5);
        map.put("java", 4);
        car.setName(map);
        car.setAttemptNumber(5);
        System.setOut(printStream);

        // when
        outputView.printCar(car);
        System.setOut(System.out);

        // then
        assertThat(outputStream.toString()).isEqualTo("pobi : -----\n" + "java : ----\n\n");
    }

    @Test
    void 우승자_선정() {
        // given
        Map<String, Integer> map = new HashMap<>();
        map.put("pobi", 5);
        map.put("java", 4);
        map.put("sleeg", 5);
        car.setName(map);
        car.setAttemptNumber(5);

        // when
        String result = inputController.choiceWinner(car);

        // then
        assertThat(result).isEqualTo("pobi, sleeg");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
