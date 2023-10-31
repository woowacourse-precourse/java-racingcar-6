package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {
    private final String carName1 = "pobi";
    private final String carName2 = "woni";
    private final String carName3 = "jun";
    private final String carNames = String.join(",", carName1, carName2, carName3);
    private final String trial = "5";

    @Test
    @DisplayName("자동차 변환을 테스트 합니다.")
    void 자동차_변환() {
        List<String> result = Parser.parseCarNames(carNames);
        assertThat(result).containsExactly(carName1, carName2, carName3);
    }

    @Test
    @DisplayName("시도 횟수 변환을 테스트 합니다.")
    void 시도_횟수_변환() {
        int result = Parser.parseTrial(trial);
        assertThat(result).isEqualTo(5);
    }
}