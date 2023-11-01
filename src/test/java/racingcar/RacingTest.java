package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RacingTest {

    @Test
    public void UpdateCarList_테스트() {
        Racing racing = new Racing();
        racing.updateCarList(Arrays.asList("car1", "car2", "car3"));
        assertEquals(3, racing.carList.size());
    }

    @Test
    public void playGame_테스트() {
        Racing racing = new Racing();

        String inputString = "testCar1,testCar2,testCar3";
        int numberOfTry = 5;
        List<String> carArray = Arrays.asList(inputString.split(","));


        racing.updateCarList(carArray);
        for (int i = 0; i < numberOfTry; i++) {
            racing.executingGame(racing.carList);
            OutputView.printExecutionMessage(racing.carList);
        }

        assertNotNull(racing.getWinner());
    }
}
