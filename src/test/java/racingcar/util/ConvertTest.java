package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConvertTest {

    @Test
    @DisplayName("문자열을 받아 쉼표를 기준으로 리스트로 변환한다.")
    void should_ConvertToListUsingComma_When_ReceiveString() {
        String inputValue = "car1,car2,car3";

        List<String> carNames = Convert.stringToListUsingComma(inputValue);

        assertThat(carNames.size()).isEqualTo(3);
        assertThat(carNames.get(0)).isEqualTo("car1");
        assertThat(carNames.get(1)).isEqualTo("car2");
        assertThat(carNames.get(2)).isEqualTo("car3");
    }

    @Test
    @DisplayName("문자열을 받아 정수로 변환한다.")
    void should_ConvertToInteger_When_ReceiveString() {
        String inputValue = "5";

        Integer attemptCount = Convert.stringToInteger(inputValue);

        assertThat(attemptCount).isEqualTo(5);
    }

    @Test
    @DisplayName("문자열을 정수로 변환하는 과정에서 NumberFormatException이 발생하면 IllegalArgumentException을 고의로 발생시킨다.")
    void should_ThrowIllegalArgumentException_When_OccurNumberFormatException() {
        String inputValue = "a";

        assertThatThrownBy(() -> Convert.stringToInteger(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
