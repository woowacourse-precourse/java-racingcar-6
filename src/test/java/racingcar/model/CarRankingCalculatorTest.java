package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.LinkedHashMap;

public class CarRankingCalculatorTest {

    @Test
    void 우승자_1명_테스트() {
        CarRankingCalculator carRankingCalculator = new CarRankingCalculator();

        LinkedHashMap<String, String> carAndDistance = new LinkedHashMap<>();
        carAndDistance.put("dokgo","--");
        carAndDistance.put("may","--");
        carAndDistance.put("cat","---");
        carAndDistance.put("uncle","----");
        carAndDistance.put("king","-----");

        assertThat(carRankingCalculator.rankingCheck(carAndDistance)).isEqualTo("king");
    }

    @Test
    void 우승자_N명_테스트() {
        CarRankingCalculator carRankingCalculator = new CarRankingCalculator();

        LinkedHashMap<String, String> carAndDistance = new LinkedHashMap<>();
        carAndDistance.put("dokgo","--");
        carAndDistance.put("may","-");
        carAndDistance.put("cat","-----");
        carAndDistance.put("uncle","-----");
        carAndDistance.put("king","-----");

        assertThat(carRankingCalculator.rankingCheck(carAndDistance)).isEqualTo("cat, uncle, king");
    }
}
