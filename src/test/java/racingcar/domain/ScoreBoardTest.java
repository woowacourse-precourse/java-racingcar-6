package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
}