package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @Test
    @DisplayName("각 이름이 쉼표에 의해 잘 나누어지는지 확인")
    public void inputNames() {
        assertThat(InputView.splitNames("poky,minsu,pobi"))
                .contains("poky", "minsu", "pobi");
    }
}
