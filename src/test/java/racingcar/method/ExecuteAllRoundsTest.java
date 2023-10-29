package racingcar.method;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExecuteAllRoundsTest {

    @Test
    void 자동차경주_랜덤값_생성_테스트() {

        LinkedHashMap<String, Integer> carNameAndMovementCountMap = new LinkedHashMap<>();
        carNameAndMovementCountMap.put("Jun", 0);
        carNameAndMovementCountMap.put("Alex", 0);
        carNameAndMovementCountMap.put("David", 0);

        Map<String, Integer> afterExecuteMap = Application.executeAllRounds(carNameAndMovementCountMap, 100);
        Assertions.assertThat(afterExecuteMap).containsKeys("Jun", "Alex", "David");
        Assertions.assertThat(afterExecuteMap).doesNotContainValue(0); // 3 * (0.6)^100 의 확률로 테스트 실패
        Assertions.assertThat(afterExecuteMap).doesNotContainValue(100); // 3 * (0.4)^100 의 확률로 테스트 실패
    }
}
