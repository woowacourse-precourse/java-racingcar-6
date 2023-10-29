package racingcar;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacePreparationTest {

    RacePreparation racePreparation = new RacePreparation();

    @DisplayName("자동차 이름들을 가지고 점수판을 만드는 기능 테스트")
    @Test
    public void makeScoreBoardTest() throws Exception {
        //given
        List<String> carNames = List.of("cat", "dog", "cow", "eagle");
        Map<String, StringBuilder> result = new LinkedHashMap<>();
        result.put("cat", new StringBuilder());
        result.put("dog", new StringBuilder());
        result.put("cow", new StringBuilder());
        result.put("eagle", new StringBuilder());

        //when
        Map<String, StringBuilder> scoreBoard = racePreparation.makeScoreBoard(carNames);
        //then
        assertThat(scoreBoard.size()).isEqualTo(result.size());
        for (String carName : carNames) {
            assertTrue(scoreBoard.containsKey(carName));
            assertThat(result.get(carName).toString()).isEqualTo(scoreBoard.get(carName).toString());
        }

    }
}