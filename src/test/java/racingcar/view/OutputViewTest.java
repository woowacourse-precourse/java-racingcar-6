package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private final OutputView outputView = new OutputView();

    @DisplayName("게임의 진행상태를 StringBuilder 저장 후 출력한다.")
    @Test
    void appendRaceStatus() {
        // given
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> result = new LinkedHashMap<>();
        result.put("pobi", 3);
        result.put("woni", 5);
        result.put("jun", 2);

        // when
        outputView.appendRaceStatus(sb, result);

        // then
        String testSb = "pobi : ---\n" +
                "woni : -----\n" +
                "jun : --\n" +
                "\n";

        assertThat(sb.toString()).isEqualTo(testSb);
    }
}