package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.User;

class UserInputTest {
    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void 입력받은_자동차_이름_마지막에_콤마가_있는지_테스트() {
        String input1 = "test1,test2,test3";
        String input2 = "test1,test2,,test3";
        String input3 = "test1,test2,test3,";
        String input4 = ",";

        Assertions.assertThatCode(() -> user.checkLastComma(input1)).doesNotThrowAnyException();
        Assertions.assertThatCode(() -> user.checkLastComma(input2)).doesNotThrowAnyException();
        assertThatThrownBy(() -> user.checkLastComma(input3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.checkLastComma(input4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_길이_테스트() {
        String input1 = "test1";
        String input2 = "1";
        String input3 = "test12";
        String input4 = "";

        Assertions.assertThatCode(() -> user.checkLengthName(input1)).doesNotThrowAnyException();
        Assertions.assertThatCode(() -> user.checkLengthName(input2)).doesNotThrowAnyException();
        assertThatThrownBy(() -> user.checkLengthName(input3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.checkLengthName(input4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_공백_테스트() {
        String input1 = "test1";
        String input2 = "1";
        String input3 = " test";
        String input4 = "";

        Assertions.assertThatCode(() -> user.checkSpaceInName(input1)).doesNotThrowAnyException();
        Assertions.assertThatCode(() -> user.checkSpaceInName(input2)).doesNotThrowAnyException();
        assertThatThrownBy(() -> user.checkSpaceInName(input3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.checkSpaceInName(input4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_중복_테스트() {
        List<String> carNames1 = Arrays.asList("test1,test2,test3".split(","));
        List<String> carNames2 = Arrays.asList("test1,Test1,test".split(","));
        List<String> carNames3 = Arrays.asList("test1,test1,test3".split(","));
        List<String> carNames4 = Arrays.asList("test1,T,T".split(","));

        Assertions.assertThatCode(() -> user.checkDuplicateName(carNames1)).doesNotThrowAnyException();
        Assertions.assertThatCode(() -> user.checkDuplicateName(carNames2)).doesNotThrowAnyException();
        assertThatThrownBy(() -> user.checkDuplicateName(carNames3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.checkDuplicateName(carNames4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_입력이_올바른_숫자인지_테스트() {
        String input1 = "1";
        String input2 = "-12";
        String input3 = "0";
        String input4 = " 123";
        String input5 = "2147483648";
        String input6 = "abc";

        Assertions.assertThatCode(() -> user.checkTryNumber(input1)).doesNotThrowAnyException();
        Assertions.assertThatCode(() -> user.checkTryNumber(input2)).doesNotThrowAnyException();
        Assertions.assertThatCode(() -> user.checkTryNumber(input3)).doesNotThrowAnyException();
        assertThatThrownBy(() -> user.checkTryNumber(input4)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.checkTryNumber(input5)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.checkTryNumber(input6)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_숫자_범위_테스트() {
        int input1 = 5;
        int input2 = 1234;
        int input3 = 0;
        int input4 = -12;

        Assertions.assertThatCode(() -> user.checkNegativeNumber(input1)).doesNotThrowAnyException();
        Assertions.assertThatCode(() -> user.checkNegativeNumber(input2)).doesNotThrowAnyException();
        assertThatThrownBy(() -> user.checkNegativeNumber(input3)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.checkNegativeNumber(input4)).isInstanceOf(IllegalArgumentException.class);
    }
}