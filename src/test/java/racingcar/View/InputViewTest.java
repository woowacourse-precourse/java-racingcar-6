package racingcar.View;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    @DisplayName("이름 입력값 : 공백 및 콤마 제거 검증")
    @Test
    void splitByCommaAndTrim() {
        String inputString = "pobi    ,\t\twoni  , jun   \t\n";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);
        InputView inputView = new InputView(System.out);
        List<String> names = inputView.inputCarNames();

        Assertions.assertThat(names)
                .hasSize(3)
                .contains("pobi", "woni", "jun");
    }

    @DisplayName("이름 입력값 : 중복 예외 검증")
    @Test
    void inputDistinctNames() {
        String inputString = "pobi, pobi, woni";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        InputView inputView = new InputView(System.out);
        Assertions.assertThatThrownBy(inputView::inputCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }
}