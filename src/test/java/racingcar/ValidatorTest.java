package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.Validator;

class ValidatorTest {
    final Validator validator = Validator.getInstance();

    @Test
    @DisplayName("예외 - 자동차 이름을 입력하지 않는다.")
    void test1() {
        //given
        final String name = "";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> validator.carNames(name));
    }

    @Test
    @DisplayName("예외 - 자동차 이름을 하나만 입력한다.")
    void test2() {
        //given
        final String name = "고민석";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> validator.carNames(name));
    }

    @Test
    @DisplayName("예외 - 시도 횟수 입력을 하지 않는다.")
    void test3() {
        //given
        final String playTimes = "";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> validator.playTimes(playTimes));
    }

    @Test
    @DisplayName("예외 - 시도 횟수를 숫자가 아닌 다른 문자열을 입력한다.")
    void test4() {
        //given
        final String playTimes = "a";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> validator.playTimes(playTimes));
    }

    @Test
    @DisplayName("예외 - 쉼표가 입력 처음과 끝에 존재한다.")
    void test5() {
        //given
        final String carNames1 = ",go,min,seok";
        final String carNames2 = "go,min,seok,";
        final String carNames3 = ",go,min,seok,";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> validator.correctCommaLocation(carNames1));
        assertThatIllegalArgumentException().isThrownBy(() -> validator.correctCommaLocation(carNames2));
        assertThatIllegalArgumentException().isThrownBy(() -> validator.correctCommaLocation(carNames3));
    }

    @Test
    @DisplayName("예외 - 쉼표가 연속된다.")
    void test6() {
        //given
        final String carNames = "go,,min,seok";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> validator.correctCommaLocation(carNames));
    }

    @Test
    @DisplayName("예외 - 자동차 이름이 중복된다.")
    void test7() {
        //given
        List<String> members = List.of("go", "go", "min");
        String carNames = "go,go,min";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> validator.duplicateCarName(members, carNames));
    }
}
