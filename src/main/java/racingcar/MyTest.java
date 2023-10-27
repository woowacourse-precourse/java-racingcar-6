package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MyTest {
    @Test
    public void ex중복여부검사함수작동() {
        assertThat(InputView.isNotDuplicate(new String[] {"abc", "abc"}))
                .isEqualTo(false);
        assertThat(InputView.isNotDuplicate(new String[] {"abc", "bc"}))
                .isEqualTo(true);
    }
    @Test
    public void 공백입력예외검사작동() {
        boolean exceptionCatched = false;

        try {
            // 오류 유발 코드
            InputView.inputToArray("");

        } catch (IllegalArgumentException e) {
            exceptionCatched = true;
        }
        assertThat(exceptionCatched)
                .isEqualTo(true);
    }
    @Test
    public void 글자5자이상예외검사작동() {
        boolean exceptionCatched = false;

        try {
            // 여기에 오류 유발 코드를 구현한다.
            InputView.inputToArray("abcdef,agdwrh");

        } catch (IllegalArgumentException e) {
            exceptionCatched = true;
        }
        assertThat(exceptionCatched)
                .isEqualTo(true);
    }

}
