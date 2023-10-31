package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingResultTest {
    static RacingResult racingResult;
    static Map<String, Integer> records;

    @BeforeEach
    void setUp() {
        racingResult = new RacingResult();
        records = new HashMap<>();
    }

    @Test
    void 레이싱_전진거리의_최대값을_찾는다() {
        records.put("pobi",7);
        records.put("java",3);
        int maxDistance = racingResult.findMaximumDistance(records);
        assertThat(maxDistance).isEqualTo(7);
    }

    @Test
    void 우승자가_한_명일_경우_한_명만_출력() {
        records.put("pobi",7);
        records.put("java",3);
        int maxDistance = racingResult.findMaximumDistance(records);
        List<String> winners = racingResult.findWinners(maxDistance, records);

        assertThat(winners).contains("pobi");
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    void 우승자가_여러_명일_경우_쉼표로_구분하여_출력() {
        records.put("pobi",7);
        records.put("java",7);
        int maxDistance = racingResult.findMaximumDistance(records);
        List<String> winners = racingResult.findWinners(maxDistance, records);

        assertThat(winners).contains("pobi", "java");
        assertThat(winners).containsExactly("pobi", "java");
    }

}
