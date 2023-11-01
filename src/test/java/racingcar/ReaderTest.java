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
        입력("no");
        assertThatThrownBy(() -> Reader.attempts()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 실수_형태_시도_횟수_입력_시_예외_발생() {
        입력("1.23");
        assertThatThrownBy(() -> Reader.attempts()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정수_형태_시도_횟수_입력_시_해당하는_정수값_반환() {
        입력("10");
        assertThat(Reader.attempts()).isEqualTo(10);
    }

    @Test
    void 입력받은_자동차_이름들을_문자열_배열로_반환한다() {
        입력("love,hate,you");
        assertThat(Reader.carNames()).usingRecursiveComparison().isEqualTo(new String[]{"love", "hate", "you"});
    }

    private void 입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

}