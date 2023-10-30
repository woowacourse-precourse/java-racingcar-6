package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.domain.OutputView;

class OutputViewTest extends NsTest {

    @Test
    void printCarsLocation_테스트() {
        // given
        Map<String, Integer> moveCountMap = new LinkedHashMap<>();
        moveCountMap.put("pobi", 2);
        moveCountMap.put("woni", 1);
        // when
        OutputView.printCarsLocation(moveCountMap);
        // then
        assertThat(output()).contains("pobi : --", "woni : -");
    }

    @Test
    void printWinner() {
        // given
        List<String> winnerList = Arrays.asList("pobi", "jun");
        // when
        OutputView.printWinner(winnerList);
        // then
        assertThat(output()).contains("최종 우승자 : pobi, jun");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}