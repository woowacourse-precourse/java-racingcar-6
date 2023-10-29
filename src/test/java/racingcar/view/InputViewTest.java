package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private final InputStream originalSystemIn = System.in;

    @AfterEach
    public void restoreSystemInStream() {
        System.setIn(originalSystemIn);
    }

    @Test
    void 자동차이름_입력테스트() {
        String input = "car1,car2,car3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String carNames = InputView.getUserInput();
        assertThat(carNames).isEqualTo(input);
    }

    @Test
    void 자동차이름을_구분자_쉼표로_나누기() {
        String carNamesInput = "pobi,woni,jun";
        String[] splitNames = InputView.splitCarNames(carNamesInput);
        assertThat(splitNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 자동차이름_입력받아서_리스트에_담는_통합테스트() {
        String input = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> carNames = InputView.getCarNames();

        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 자동차이름_5자초과입력_예외발생_통합테스트() {
        String input = "pobi,woni,jun123";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> InputView.getCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_정상입력_숫자반환_통합테스트() {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int attemptCount = InputView.getAttemptCount();
        assertThat(attemptCount).isEqualTo(5);
    }

    @Test
    void 시도횟수_문자입력_에러발생_통합테스트() {
        String input = "ab";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> InputView.getAttemptCount())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
