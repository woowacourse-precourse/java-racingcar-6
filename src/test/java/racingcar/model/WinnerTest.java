package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnerTest {
    @Test
    void  우승자_테스트()  {
        // given
        String name1 = "inho";
        String name2 = "ru";

        List<CarName> carNames = new ArrayList<>();
        carNames.add(new CarName(name1));
        carNames.add(new CarName(name2));

        // when
        Winner winner = new Winner();

        // then
        assertThat(winner.buildWinnersString(carNames))
                .contains("inho, ru");
    }
    @Test
    void  가장큰_스코어_찾기()  {
        // given
        String name1 = "inho";
        String name2 = "se";
        String name3 = "agg";

        HashMap<CarName, Integer> carMap = new HashMap<>();
        carMap.put(new CarName(name1),5);
        carMap.put(new CarName(name2),1);
        carMap.put(new CarName(name3),3);

        // when
        int maxScore = Winner.findMaxScore(carMap);

        // then
        assertEquals(5, maxScore);
    }
    @Test
    void  우승자_리스트_테스트()  {
        // given
        String name1 = "inho";
        String name2 = "se";
        String name3 = "agg";

        HashMap<CarName, Integer> carMap = new HashMap<>();
        carMap.put(new CarName(name1),5);
        carMap.put(new CarName(name2),1);
        carMap.put(new CarName(name3),3);
        int maxScore = 5;

        // when
        List<CarName> winningCarNames = Winner.findWinningCarNames(carMap, maxScore);

        // then
        assertThat(winningCarNames.contains("inho"));
    }
}
