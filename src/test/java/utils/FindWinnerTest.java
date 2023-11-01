package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class FindWinnerTest {
    @Test
    void getMostMovedCarTest() {
        ArrayList<String> carDistanceList = new ArrayList<>();
        carDistanceList.add("a : -");
        carDistanceList.add("b : ");
        ArrayList<String> result = FindWinner.getMostMovedCar(carDistanceList);

        assertThat(result).containsExactly("a");
    }

    @Test
    void getRaceResultTest() {
        ArrayList<String> carDistanceList = new ArrayList<>();
        carDistanceList.add("a : -");
        carDistanceList.add("b : ");
        carDistanceList.add("c : -");
        String result = FindWinner.getRaceResult(carDistanceList);

        assertThat(result).isEqualTo("최종 우승자 : a, c");
    }
}
