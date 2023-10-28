package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class SelectFinalWinnerTest {

    @Test
    void 단독_우승자_선정() {
        LinkedHashMap<String, Integer> carNameAndMovementCountMap = new LinkedHashMap<>();
        carNameAndMovementCountMap.put("Jun", 5);
        carNameAndMovementCountMap.put("Alex", 3);
        carNameAndMovementCountMap.put("David", 2);

        Assertions.assertThat(Application.selectFinalWinner(carNameAndMovementCountMap)).contains("Jun");
    }

    @Test
    void 공동_우승자_선정() {
        LinkedHashMap<String, Integer> carNameAndMovementCountMap = new LinkedHashMap<>();
        carNameAndMovementCountMap.put("Jun", 5);
        carNameAndMovementCountMap.put("Alex", 5);
        carNameAndMovementCountMap.put("David", 2);

        Assertions.assertThat(Application.selectFinalWinner(carNameAndMovementCountMap)).contains("Jun", "Alex");
    }
}