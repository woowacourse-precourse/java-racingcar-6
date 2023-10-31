package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class GameResultTest {
    @Test
    void gameResult_게임_결과_확인() {
        int winnerpoint = 5;
        List<String> carNameList = new ArrayList<>();
        Map<String, Integer> point = new HashMap<>();
        GameResult gameResult = new GameResult();
        String result = "pobi, jun";

        carNameList.add("pobi");
        carNameList.add("woni");
        carNameList.add("jun");

        point.put("pobi", 5);
        point.put("woni", 4);
        point.put("jun", 5);

        assertThat(gameResult.gameResult(winnerpoint, carNameList, point)).isEqualTo(result);

    }
}
