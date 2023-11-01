package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.view.InputView.displayAttemptNumberInputView;
import static racingcar.view.InputView.displayCarNamesInputView;

class InputViewTest {

    @BeforeEach
    void resetBuffer() {
        Console.close();
    }

    @Test
    void 경주할_자동차_이름을_입력받는다() {
        // given
        setInput("성겸,성민");

        // when
        String[] names = displayCarNamesInputView();

        // then
        Assertions.assertThat(names).contains("성겸", "성민");
    }

    @Test
    void 경주할_자동차_이름을_입력받는다_글자수_예외처리() {
        setInput("성겸,성민,abcdef");
        assertThatThrownBy(() -> displayCarNamesInputView())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경주할_자동차_이름을_입력받는다_공백_예외처리() {
        setInput("성겸,성민, abcdef");
        assertThatThrownBy(() -> displayCarNamesInputView())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경주할_자동차_이름을_입력받는다_특수문자_예외처리() {
        setInput("성겸,@성민");
        assertThatThrownBy(() -> displayCarNamesInputView())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경주할_자동차_이름을_입력받는다_콤마연속_예외처리() {
        setInput("성겸,,성민");
        assertThatThrownBy(() -> displayCarNamesInputView())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경주할_자동차_이름을_입력받는다_중복_예외처리() {
        setInput("성겸,성겸");
        assertThatThrownBy(() -> displayCarNamesInputView())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도할_횟수를_입력받는다() {
        // given
        setInput("5");

        // when
        Integer attempt = displayAttemptNumberInputView();

        // then
        Assertions.assertThat(attempt).isEqualTo(5);
    }

    @Test
    void 시도할_횟수를_입력받는다_정수가_아닌_입력_예외처리() {
        setInput("오");
        assertThatThrownBy(() -> displayAttemptNumberInputView())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도할_횟수를_입력받는다_양의_정수가_아닌_입력_예외처리() {
        setInput("-5");
        assertThatThrownBy(() -> displayAttemptNumberInputView())
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void setInput(String input) {
        final byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}