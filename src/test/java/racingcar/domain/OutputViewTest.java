package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.RacingcarTestConstantUtils.DELIMITER;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Application;

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

    @ParameterizedTest
    @CsvSource({"pobi,최종 우승자 : pobi", "'pobi,jun',최종 우승자 : pobi, jun"})
    void printWinner_테스트(String names, String winningMessage) {
        // given
        List<String> winnerList = Arrays.asList(names.split(DELIMITER));
        // when
        OutputView.printWinner(winnerList);
        // then
        assertThat(output()).contains(winningMessage);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}