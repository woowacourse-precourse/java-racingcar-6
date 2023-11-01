package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


public class PlayerTest {
    @Test
    @DisplayName("입력 값을 , 구분자로 구분하고 반환된 리스트 원소에 , 없는지 확인")
    void testSplitCarNames() {
        Player cars = new Player();
        String testInput = "Tom, tyla, Judy";

        ArrayList<String> userInputCarList = cars.createPlayerCarList(testInput);
        assertThat(userInputCarList).contains("Tom", "tyla", "Judy");
    }
}
