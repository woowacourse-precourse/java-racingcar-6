package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.test.MyTest;

@SuppressWarnings("NonAsciiCharacters")
class InputViewTest extends MyTest {
    @Test
    void 시도할_횟수를_입력받을_수_있다() {
        String arg = "10";
        InputView inputView = new InputView();

        Integer actual = input(arg, inputView::getAttemptCount);

        assertThat(output()).isEqualTo("시도할 회수는 몇회인가요?\n");
        assertThat(actual).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = """
            a,' ',@
            """)
    void 시도_횟수가_숫자가_아니면_에러_발생(String arg) {
        System.setIn(new ByteArrayInputStream(arg.getBytes()));
        InputView inputView = new InputView();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> input(arg, inputView::getAttemptCount));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void 시도_횟수가_1_보다_작으면_에러_발생(String attemptCount) {
        System.setIn(new ByteArrayInputStream(attemptCount.getBytes()));
        InputView inputView = new InputView();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> input(attemptCount, inputView::getAttemptCount));
    }

    @Test
    void 이름을_입력받을_수_있다() {
        String arg = "a,ab,abc,12345";
        InputView inputView = new InputView();

        List<String> actual = input(arg, inputView::getNames);

        assertThat(output()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        assertThat(actual).isEqualTo(List.of("a", "ab", "abc", "12345"));
    }
}
