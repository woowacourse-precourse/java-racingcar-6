package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashMap;

public class CarRankingCalculatorTest {

    @Test
    void 우승자_1명_테스트() {
        CarRankingCalculator carRankingCalculator = new CarRankingCalculator();

        HashMap<String, String> carAndDistance = new HashMap<>();
        carAndDistance.put("dokgo","__");
        carAndDistance.put("may","_");
        carAndDistance.put("cat","___");
        carAndDistance.put("uncle","____");
        carAndDistance.put("king","_____");

        assertThat(carRankingCalculator.rankingCheck(carAndDistance)).isEqualTo("king");
    }

    @Test
    void 우승자_N명_테스트() {
        CarRankingCalculator carRankingCalculator = new CarRankingCalculator();

        HashMap<String, String> carAndDistance = new HashMap<>();
        carAndDistance.put("dokgo","__");
        carAndDistance.put("may","_");
        carAndDistance.put("cat","_____");
        carAndDistance.put("uncle","_____");
        carAndDistance.put("king","_____");

        assertThat(carRankingCalculator.rankingCheck(carAndDistance)).isEqualTo("cat,uncle,king");
    }
}
