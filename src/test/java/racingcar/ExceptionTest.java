package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.util.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {

    private final Validator validator = new Validator();

    @Test
    void 자동차_이름이_다섯글자_이상의_경우_테스트(){
        //given
        String input = "abcdefg,abc";

        //then
        assertThatThrownBy(() -> validator.validateCarNames(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름의 길이는 5이하여야 합니다.");
    }

    @Test
    void 자동차_이름이_한글자_미만의_경우_테스트() {
        //given
        String input = ",,";

        //then
        assertThatThrownBy(() -> validator.validateCarNames(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름의 길이는 1이상여야 합니다.");
    }

    @Test
    void 자동차_이름이_중복이_있을경우_테스트(){
        //given
        String input = "abc,abc";

        //then
        assertThatThrownBy(() -> validator.validateCarNames(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름이 중복 되면 안됩니다.");
    }

    @Test
    void 시도횟수가_정수가_아닐_경우_테스트() {
        //given
        String input = "not_int";

        //then
        assertThatThrownBy(() -> validator.validateAttemptNumber(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도횟수는 정수여야합니다.");
    }

    @Test
    void 시도횟수가_양수가_아닐_경우_테스트(){
        //given
        String input = "-10";

        //then
        assertThatThrownBy(() -> validator.validateAttemptNumber(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도횟수는 양수여야합니다.");
    }
}
