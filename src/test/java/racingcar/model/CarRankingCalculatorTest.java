package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.LinkedHashMap;

public class CarRankingCalculatorTest {

    @Test
    void 우승자_1명_테스트() {
        CarRankingCalculator carRankingCalculator = new CarRankingCalculator();

        LinkedHashMap<String, String> carAndDistance = new LinkedHashMap<>();
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

        LinkedHashMap<String, String> carAndDistance = new LinkedHashMap<>();
        carAndDistance.put("dokgo","__");
        carAndDistance.put("may","_");
        carAndDistance.put("cat","_____");
        carAndDistance.put("uncle","_____");
        carAndDistance.put("king","_____");

        assertThat(carRankingCalculator.rankingCheck(carAndDistance)).isEqualTo("cat,uncle,king");
    }
}
