package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ScoreBoardTest {

    @Test
    void getCarPositionTest1() {
        ScoreBoard scoreBoard = new ScoreBoard();
        Car car = new Car();
        car.carPosition = 4;
        String result = scoreBoard.getCarPosition(car);
        assertThat(result).isEqualTo("----");
    }

    @Test
    void getCarPositionTest2() {
        ScoreBoard scoreBoard = new ScoreBoard();
        Car car = new Car();
        car.carPosition = 2;
        String result = scoreBoard.getCarPosition(car);
        assertThat(result).isEqualTo("--");
    }

    @Test
    void getCarPositionTest3() {
        ScoreBoard scoreBoard = new ScoreBoard();
        Car car = new Car();
        car.carPosition = 5;
        String result = scoreBoard.getCarPosition(car);
        assertThat(result).isEqualTo("-----");
    }

    @Test
    void showCarsScoreTest() {
        ScoreBoard scoreBoard = new ScoreBoard();
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            carList.add(new Car("" + i));
        }
        scoreBoard.showCarsScore(carList, 3);
    }
}