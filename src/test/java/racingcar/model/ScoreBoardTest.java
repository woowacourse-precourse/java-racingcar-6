package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreBoardTest {
    @Test
    @DisplayName("Score가 잘 기록되는지 확인")
    public void recordScore(){
        List<Car> racingCars = new ArrayList<>();
        Car pobiCar = new Car("pobi");
        pobiCar.moveForward(1);
        Car dobiCar = new Car("dobi");
        dobiCar.moveForward(5);
        racingCars.add(pobiCar);
        racingCars.add(dobiCar);

        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.recordScore(1,racingCars);
        assertThat(scoreBoard.getScoreForRound(1)).isEqualTo(racingCars);
    }

}