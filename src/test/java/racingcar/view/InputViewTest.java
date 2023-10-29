package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    @ParameterizedTest
    @DisplayName("자동차 이름 배열 변환 테스트")
    @ValueSource(strings = "pobi,woni,jun")
    public void inputCarNameTest(String input) {
        List<String> carNames = new ArrayList<>(List.of(input.split(",")));
        assertThat(carNames).contains("pobi","woni","jun");
    }
}
