package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    RacingGame racingGame;

    @BeforeEach
    void init() {
        racingGame = new RacingGame();
    }

    @Test
    void inputCarName_메서드로_Car_추가_확인() {
        String[] carNames = {"pobi", "yung", "jun"};
        racingGame.inputCarName(carNames);

        assertThat(racingGame.cars.size()).isEqualTo(3);
    }

    @Test
    void inputTry_메서드로_정수_변환() {
        String input = "1";
        int result = racingGame.inputTry(input);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void getWinner_메서드로_우승자_확인() {
        List<Car> cars = new ArrayList<>();
        Output output = new Output();

        cars.add(new Car("pobi", 2));
        cars.add(new Car("yung", 1));
        cars.add(new Car("jun", 2));

        List<Car> results = racingGame.getWinner(cars);
        StringBuilder result = output.winner(results);

        assertThat(result).contains("pobi, jun");
    }
}