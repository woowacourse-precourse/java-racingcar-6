package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


public class PlayerTest {
    @Test
    @DisplayName("입력 값을 , 구분자로 구분하고 다른 구분자가 주어진 경우 예외 처리하는지 확인")
    void testSplitCarNames() {
        Player cars = new Player();
        String testInput = "Tom, tyla, Judy";
        String[] testInputCarList = testInput.replace(" ", "").split(",");

        ArrayList<String> userInputCarList = cars.createPlayerCarList(testInput);
        assertThat(userInputCarList).containsExactly(testInputCarList);

    }
}
