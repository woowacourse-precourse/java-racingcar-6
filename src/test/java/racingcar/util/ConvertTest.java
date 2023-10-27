package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConvertTest {

    @Test
    @DisplayName("문자열을 받아 쉼표를 기준으로 리스트로 변환한다.")
    void should_ConvertToListUsingComma_When_ReceiveString() {
        String inputValue = "park,yong,hyeon";

        List<String> carNames = Convert.stringToListUsingComma(inputValue);

        assertThat(carNames.size()).isEqualTo(3);
        assertThat(carNames.get(0)).isEqualTo("park");
        assertThat(carNames.get(1)).isEqualTo("yong");
        assertThat(carNames.get(2)).isEqualTo("hyeon");
    }

    @Test
    @DisplayName("문자열을 받아 정수로 변환한다.")
    void should_ConvertToInteger_When_ReceiveString() {
        String inputValue = "5";

        Integer attemptCount = Convert.stringToInteger(inputValue);

        assertThat(attemptCount).isEqualTo(5);
    }
}
