package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingBoardTest {

    RacingBoard racingBoard;

    @BeforeEach
    public void beforeEach() {
        racingBoard = new RacingBoard();
    }

    @Test
    void viewWinner() {
        //given
        String compareStr = "abc, def, ghi";
        String[] testStrArray = {"abc", "def", "ghi"};
        ArrayList<String> testWinnerList = new ArrayList<>(Arrays.asList(testStrArray));
        racingBoard.recordWinner(testWinnerList);
        //when
        String result = racingBoard.viewWinner();
        //then
        Assertions.assertThat(result).isEqualTo(compareStr);
    }

    @Test
    void viewExecution() {
        //given
        String resultStr;
        ArrayList<String> compapreArrayList = new ArrayList<>(Arrays.asList("car1", "car2", "car4"));
        Car car1 = new Car("car1", 3);
        Car car2 = new Car("car2", 3);
        Car car3 = new Car("car3", 2);
        Car car4 = new Car("car4", 3);
        racingBoard.join(car1);
        racingBoard.join(car2);
        racingBoard.join(car3);
        racingBoard.join(car4);
        //when
        resultStr = racingBoard.viewExecution();
        //then
        System.out.println(resultStr);
    }
}