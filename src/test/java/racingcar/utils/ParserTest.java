package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {
    @Test
    @DisplayName("자동차 변환을 테스트 합니다.")
    void 자동차_변환() {
        String inputCarNames = "pobi,woni,jun";
        List<String> carNames = Parser.parseCarNames(inputCarNames);

        assertThat(Arrays.asList("pobi", "woni", "jun")).containsAll(carNames);
    }

    @Test
    @DisplayName("시도 횟수 변환을 테스트 합니다.")
    void 시도_횟수_변환() {
        String inputTrial = "5";
        int trial = Parser.parseTrial(inputTrial);

        // 테스트 결과 검증
        assertThat(5).isEqualTo(trial);
    }
}