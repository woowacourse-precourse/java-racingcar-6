package racingcar.utils;

import org.assertj.core.api.AbstractIntegerAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {
    @Test
    void split() {
        String input = "";
        String[] split = input.split(",");
        System.out.println(split.length);  //1
        System.out.println(split[0].length());  //0

        String input2 = " ";
        String[] split2 = input2.split(",");
        System.out.println(split2.length);  //1
        System.out.println(split2[0].length());  //1
    }

    @Test
    void split1() {
        String input = ",";
        String[] split = input.split(",");
        assertThat(split.length).isEqualTo(0);
        assertThatThrownBy(() -> split[0].isBlank()).isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    void split1_2() {
        String input = ",,";
        String[] split = input.split(",");
        assertThat(split.length).isEqualTo(0);
        assertThatThrownBy(() -> split[0].isBlank()).isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    void split2() {
        String input = "test,";
        String[] split = input.split(",");  //"test"
        assertThat(split.length).isEqualTo(1);
        assertThatThrownBy(() -> split[1].isBlank()).isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    void split3() {
        String input = ",test";
        String[] split = input.split(",");  //"", "test"
        assertThat(split.length).isEqualTo(2);
        assertThat(split[0].isBlank()).isTrue();
        assertThat(split[1].isBlank()).isFalse();

    }

    @Test
    void split4() {
        String input = ",test,";
        String[] split = input.split(",");  //"", "test"
        assertThat(split.length).isEqualTo(2);
        assertThat(split[0].isBlank()).isTrue();
        assertThat(split[1].isBlank()).isFalse();
    }

    @DisplayName("5자 이하의 이름을 쉼표로 구분하여 입력시 정상 처리 된다.")
    @Test
    void validateCarNames1() {
        List<String> names = Validator.validateCarNames("test,abcde,abc");
        assertThat(names).containsExactly("test", "abcde", "abc");
    }

    @DisplayName("이름이 6자 이상인 경우 예외 발생")
    @Test
    void validateCarNames2() {
        assertThatThrownBy(() -> Validator.validateCarNames("test,abcdef,abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 공백인 경우 예외 발생")
    @Test
    void validateCarNames3() {
        assertThatThrownBy(() -> Validator.validateCarNames("test, ,abc"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateCarNames("test,,abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백을 입력한 경우 예외 발생")
    @Test
    void validateCarNames4() {
        assertThatThrownBy(() -> Validator.validateCarNames(" "))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateCarNames(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표만 입력한 경우 예외 발생")
    @Test
    void validateCarNames5() {
        assertThatThrownBy(() -> Validator.validateCarNames(","))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateCarNames(",,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름을 하나만 입력한 경우 예외 발생")
    @Test
    void validateCarNames6() {
        assertThatIllegalArgumentException().isThrownBy(() -> Validator.validateCarNames("test"));
    }

    @DisplayName("같은 이름을 입력한 경우 예외 발생")
    @Test
    void validateCarNames7() {
        assertThatIllegalArgumentException().isThrownBy(() -> Validator.validateCarNames("test,test,abc"));
    }

    @DisplayName("게임 진행 총 횟수로 1 이상의 숫자를 입력하면 정상 처리")
    @Test
    void validateTotalRound1() {
        assertThat(Validator.validateTotalRound("3")).isEqualTo(3);
    }

    @DisplayName("게임 진행 총 횟수 문자열 입력 시 예외 발생")
    @Test
    void validateTotalRound2() {
        assertThatThrownBy(() -> Validator.validateTotalRound("a"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateTotalRound("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 진행 총 횟수 0 입력 시 예외 발생")
    @Test
    void validateTotalRound3() {
        assertThatIllegalArgumentException().isThrownBy(() -> Validator.validateTotalRound("0"));
    }
}