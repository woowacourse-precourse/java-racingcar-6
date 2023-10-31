package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;


class InputViewTest {

    @DisplayName("이름을 쉼표(,)로 분리하는지 검증")
    @Test
    void inputTest() {
        InputView inputView = new InputView();
        String input = "pobi,woni,jun";
        List<String> names = inputView.parseNames(input);
        assertThat(names).containsExactly("pobi", "woni", "jun");
    }
}