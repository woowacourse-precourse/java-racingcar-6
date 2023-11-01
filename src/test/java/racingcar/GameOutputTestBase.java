package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class GameOutputTestBase extends TestBase {
    private GameOutput gameOutput = new GameOutput();
    private Game game = new Game();

    @Test
    void printRoundResult_메서드로_매_라운드_결과_확인() {
        List<Car> carList = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));
        carList.forEach(Car::increaseMovingCount);
        gameOutput.printRoundResult(carList);

        String expectedOutput = "car1 : -\ncar2 : -\ncar3 : -";
        assertThat(output())
                .contains(expectedOutput);
    }

    @Test
    void printWinners_메서드_사용시_우승자가_한명인_경우_우승자_확인() {
        List<Car> carList = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));
        carList.forEach(Car::increaseMovingCount);
        carList.get(0).increaseMovingCount();

        List<Car> winnerList = game.getWinners(carList);
        gameOutput.printWinners(winnerList);

        String expectedOutput = "최종 우승자 : car1";
        assertThat(output())
                .isEqualTo(expectedOutput);

    }

    @Test
    void printWinners_메서드_사용시_우승자가_한명_이상인_경우_우승자_확인() {
        List<Car> carList = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));
        List<Car> winnerList = game.getWinners(carList);
        gameOutput.printWinners(winnerList);

        String expectedOutput = "최종 우승자 : car1, car2, car3";
        assertThat(output())
                .isEqualTo(expectedOutput);

    }

}