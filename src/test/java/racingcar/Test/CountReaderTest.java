package racingcar.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

@DisplayName("Validator가 포함된 CountReader 테스트")
class CountReaderTest extends NsTest {
    @Test
    @DisplayName("숫자가 아닌 영문 입력시 예외 발생")
    void 횟수에_영문입력시() {
        assertThatThrownBy(() ->
                runException("abc","aBc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 한글 입력시 예외 발생")
    void 횟수에_한글입력시() {
        assertThatThrownBy(() ->
                runException("abc","숫자"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("횟수에 띄어쓰기 입력시 예외 발생")
    void 횟수에_띄어쓰기입력시() {
        assertThatThrownBy(() ->
                runException("abc"," "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("횟수에 Enter입력시")
    void 횟수_입력시_엔터입력() {
        assertThatThrownBy(() ->
                runException("\n"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상입력")
    void 정상입력() {
        runException("abc","7");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
