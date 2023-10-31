package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.CarList;

public class CarListTest {
    private CarList carList;

    @BeforeEach
    void setUp() {
        carList = new CarList(Arrays.asList("aa", "bb", "cc", "dd"));
        List<Integer> distanceList = Arrays.asList(0, 0, 1, 1);
        carList.updateDistance(distanceList);
        carList.updateDistance(distanceList);
    }

    @Test
    void checkWinner() {
        List<String> output = carList.getWinner(2);
        List<String> answer = Arrays.asList("cc", "dd");
        assertThat(output).isEqualTo(answer);
    }

    @Test
    void checkToString() {
        String output = carList.toString();
        String answer = "aa : \n"
                + "bb : \n"
                + "cc : --\n"
                + "dd : --\n";
        assertThat(output).isEqualTo(answer);
    }

    @Test
    void checkGetMaxDistance() {
        int output = carList.getMaxDistance();
        int answer = 2;
        assertThat(output).isEqualTo(answer);
    }

}
