package racingcar.view.input;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @Test
    @DisplayName("경주할 자동차 이름들을 쉼표로 구분하며 입력할 수 있다.")
    void inputCarNames() {
        // given
        InputView inputView = new InputView(new DoubleConsoleService("tobi,ship,chan"));

        // when
        List<String> carNames = inputView.names();

        // then
        assertThat(carNames).isEqualTo(List.of("tobi", "ship", "chan"));
    }
}
