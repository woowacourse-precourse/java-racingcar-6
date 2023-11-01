package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.service.Forward;
import racingcar.service.GameService;
import racingcar.util.Parser;
import racingcar.view.OutputView;

class RacingCarTest extends NsTest {

    Parser parser;
    Forward forward;
    GameService gameService;

    private static final int NUMBER_OF_TRIAL = 2;

    @BeforeEach
    void setUp() {
        parser = new Parser();
        forward = new Forward();
        gameService = new GameService();
    }

    @Test
    void parseCarNames_메소드로_주어진_값을_구분() {
        List<Car> cars = new ArrayList<>();
        String input = "a,b";
        List<String> carNames = parser.parseCarNames(input);

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        assertThat(carNames).contains("b", "a");
        assertThat(carNames).containsExactly("a", "b");
    }

    @Test
    void parseNumberOfTrial_메소드로_주어진_값을_int로_변환() {
        String input = "5";
        int result = parser.parseNumberOfTrial(input);
        assertEquals(5, result);
    }

    @Test
    void 무작위_값_생성_테스트() {
        int randomNumber = forward.generateRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    void 자동차_전진_상황_출력_테스트() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.get(0).moveForward(1);
        cars.get(1).moveForward(2);
        OutputView.showScore(cars);

        assertThat(output()).contains("car1 : -", "car2 : --");
    }

    @Test
    void 우승자_찾기() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.get(0).moveForward(1);
        cars.get(1).moveForward(2);

        Game game = new Game(cars, NUMBER_OF_TRIAL);
        OutputView.showWinners(gameService.findWinners(game));

        assertThat(output()).contains("최종 우승자 : car2");
    }

    @Test
    void 우승자가_여러명일_경우_최종_우승자_출력() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.get(0).moveForward(2);
        cars.get(1).moveForward(2);

        Game game = new Game(cars, NUMBER_OF_TRIAL);
        OutputView.showWinners(gameService.findWinners(game));

        assertThat(output()).contains("최종 우승자 : car1, car2");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
