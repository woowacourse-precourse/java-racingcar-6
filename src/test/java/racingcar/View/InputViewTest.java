package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }

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

    @DisplayName("이동 횟수 : 입력 검증")
    @Test
    void inputTryCount() {
        String inputString = "010";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);
        InputView inputView = new InputView(System.out);
        int tryCount = inputView.inputMaxTryCount();
        Assertions.assertThat(tryCount).isEqualTo(10);
    }

    @DisplayName("이동 횟수 : 예외 검증")
    @Test
    void inputNotNumberTryCount() {
        String inputString = "qwe";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);
        InputView inputView = new InputView(System.out);

        Assertions.assertThatThrownBy(inputView::inputMaxTryCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("100 이상의 시도 횟수를 입력 시 예외가 발생한다.")
    @Test
    void inputOver100TryNumber() {
        String inputString = "100";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);
        InputView inputView = new InputView(System.out);

        Assertions.assertThatThrownBy(inputView::inputMaxTryCount)
                .isInstanceOf(IllegalArgumentException.class);
    }
}