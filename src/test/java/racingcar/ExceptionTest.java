package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {

    @Test
    public void 자동차_한대당_이름이_5글자_예외처리해라() {
        Exception exception = new Exception();

        exception.lengthCheck("tjwls,MJ"); // 옳은 입력

        assertThrows(IllegalArgumentException.class, () -> {
            exception.lengthCheck("audwls"); // 틀린 입력
        });
    }

    @Test
    public void 영어_한글_숫자_쉼표가_아니면_예외처리해라() {
        Exception exception = new Exception();

        exception.stringCompile("tjwls,MJ");

        assertThatThrownBy(() -> exception.stringCompile("Invalid#,MJ!"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 입력이 아닙니다.");
    }
}
