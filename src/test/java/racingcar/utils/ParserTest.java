package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {
    @Test
    @DisplayName("자동차 변환을 테스트 합니다.")
    void 자동차_변환() {
        String inputCarNames = "pobi,woni,jun";
        List<String> carNames = Parser.parseCarNames(inputCarNames);

        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("시도 횟수 변환을 테스트 합니다.")
    void 시도_횟수_변환() {
        String inputTrial = "5";
        int trial = Parser.parseTrial(inputTrial);

        assertThat(trial).isEqualTo(5);
    }
}