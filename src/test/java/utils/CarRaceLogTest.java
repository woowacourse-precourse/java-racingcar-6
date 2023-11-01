package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CarRaceLogTest {
    @Test
    void initCarDistanceListValidInputTest() {
        String carNameInput = "a, b";
        ArrayList<String> result = CarRaceLog.initCarDistanceList(carNameInput);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("a : ");
        expected.add("b : ");

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void initCarDistanceListEmptyInputTest() {
        String carNameInput = "";
        ArrayList<String> result = CarRaceLog.initCarDistanceList(carNameInput);

        assertThat(result).isEmpty();
    }

    @Test
    void updateCarDistanceListValidInputTest() {
        int index = 0;
        ArrayList<String> carDistanceList = new ArrayList<>();
        carDistanceList.add("a : ");
        ArrayList<String> result = CarRaceLog.updateCarDistanceList(index, carDistanceList);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("a : -");

        assertThat(result).isEqualTo(expected);
    }
}
