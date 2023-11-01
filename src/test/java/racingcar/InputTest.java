package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {
    private final InputView inputView = new InputView();

    @DisplayName("자동차 이름 제한 테스트")
    @Test
    void checkNameException() {
        String inputNames = "Ruffy123, Robin123, DFSdf123";
        List<String> names = Arrays.asList(inputNames.trim().split("[,]"));

        assertThatThrownBy(() -> inputView.checkNameException(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @DisplayName("시도 횟수 확인")
    @Test
    void checkRoundException() {
        String inputNum = "a";

        assertThatThrownBy(() -> inputView.checkRoundException(inputNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1에서 9 사이의 정수이어야 합니다.");
    }


}
