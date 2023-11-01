package racingcar.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Validator가 포함된 NameReader 기능 테스트")
class NameReaderTest extends NsTest {
    @Test
    @DisplayName("이름이 5글자 초과하면 예외 발생")
    void 이름_5글자_초과() {
        assertThatThrownBy(() ->
                runException("sddsfsd"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름에 숫자 포함되면 예외 발생")
    void 이름_숫자_포함() {
        assertThatThrownBy(() ->
                runException("sdd12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름에 띄어쓰기 포함되면 예외 발생")
    void 이름_띄어쓰기() {
        assertThatThrownBy(() ->
                runException("sd d"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름 입력시 엔터 입력하면 예외 발생")
    void 이름_입력시_엔터입력() {
        assertThatThrownBy(() ->
                runException("\n"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상입력")
    void 정상입력() {
        runException("aBc");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
