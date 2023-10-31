package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.RacingcarTestConstantUtils.DELIMITER;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RefereeTest {

    @ParameterizedTest
    @CsvSource({"1,pobi", "2,'pobi,woni'"})
    void getWinnerList_테스트(int woniCount, String winners) {
        // given
        List<String> expectedWinnerList = Arrays.asList(winners.split(DELIMITER));
        Map<String, Integer> moveCountMap = new LinkedHashMap<>();
        moveCountMap.put("pobi", 2);
        moveCountMap.put("woni", woniCount);
        Referee referee = new Referee(moveCountMap);
        // when
        List<String> winnerList = referee.getWinnerList();
        // then
        assertThat(winnerList).isEqualTo(expectedWinnerList);
    }
}