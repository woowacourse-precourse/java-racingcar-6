package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ReaderTest {

    @AfterEach
    private void 콘솔_닫기() {
        Console.close();
    }

    @Test
    void 문자_형태_시도_횟수_입력_시_예외_발생() {
        String input = "no";
        콘솔_입력(input);
        assertThatThrownBy(() -> Reader.attempts()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 실수_형태_시도_횟수_입력_시_예외_발생() {
        String input = "1.23";
        콘솔_입력(input);
        assertThatThrownBy(() -> Reader.attempts()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정수_형태_시도_횟수_입력_시_해당하는_정수값_반환() {
        String input = "10";
        콘솔_입력(input);
        assertThat(Reader.attempts()).isEqualTo(10);
    }

    private void 콘솔_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

}