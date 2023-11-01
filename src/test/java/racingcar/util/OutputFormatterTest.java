package racingcar.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class OutputFormatterTest {

    @Test
    void testGetMessageWhenInputCarNames() {
        String msg = OutputFormatter.getMessageWhenInputCarNames();
        assertThat(msg).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
    }

    @Test
    void testGetMessageWhenInputNumOfTries() {
        String msg = OutputFormatter.getMessageWhenInputNumOfTries();
        assertThat(msg).isEqualTo("시도할 회수는 몇회인가요?\n");
    }

    @Test
    void testGetMessageToIndicateToStartToShowResult() {
        String msg = OutputFormatter.getMessageToIndicateToStartToShowResult();
        assertThat(msg).isEqualTo("\n실행 결과\n");
    }

    @Test
    void testGetMessageForEachStep() {
        String[] cars = { "pobi", "woni", "jun" };
        Map<String, Integer> states = Map.of(
                cars[0], 1,
                cars[1], 0,
                cars[2], 3
        );

        String expected =
                "pobi : -\n"
                + "woni : \n"
                + "jun : ---\n\n";

        String msg = OutputFormatter.getMessageForEachStep(cars, states);

        assertThat(msg).isEqualTo(expected);
    }

    @Test
    void testGetMessageForWinners_oneWinner() {
        String[] winners = { "pobi" };
        String expected = "최종 우승자 : pobi";
        String msg = OutputFormatter.getMessageForWinners(Arrays.asList(winners));
        assertThat(msg).isEqualTo(expected);
    }

    @Test
    void testGetMessageForWinners_twoWinnes() {
        String[] winners = { "pobi, woni" };
        String expected = "최종 우승자 : pobi, woni";
        String msg = OutputFormatter.getMessageForWinners(Arrays.asList(winners));
        assertThat(msg).isEqualTo(expected);
    }

    @Test
    void testGetMessageForWinners_threeWinners() {
        String[] winners = { "pobi, woni", "jun" };
        String expected = "최종 우승자 : pobi, woni, jun";
        String msg = OutputFormatter.getMessageForWinners(Arrays.asList(winners));
        assertThat(msg).isEqualTo(expected);
    }
}