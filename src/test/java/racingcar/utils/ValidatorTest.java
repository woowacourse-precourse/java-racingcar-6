package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {
    @DisplayName("5자 이하의 이름을 쉼표로 구분하여 입력시 정상 처리 된다.")
    @Test
    void validateCarNames1() {
        String carNamesInput = "test,abcde,abc";
        CarNameValidator.validateCarNamesInput(carNamesInput);
        List<String> carNames = Arrays.asList(carNamesInput.split(","));
        assertThat(carNames.size()).isEqualTo(3);
        assertThat(carNames).containsExactly("test", "abcde", "abc");
    }

    @DisplayName("이름이 6자 이상인 경우 예외 발생")
    @Test
    void validateCarNames2() {
        assertThatThrownBy(() -> CarNameValidator.validateCarNamesInput("test,abcdef,abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 공백인 경우 예외 발생")
    @Test
    void validateCarNames3() {
        assertThatThrownBy(() -> CarNameValidator.validateCarNamesInput("test, ,abc"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CarNameValidator.validateCarNamesInput("test,,abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백을 입력한 경우 예외 발생")
    @Test
    void validateCarNames4() {
        assertThatThrownBy(() -> CarNameValidator.validateCarNamesInput(" "))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CarNameValidator.validateCarNamesInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표만 입력한 경우 예외 발생")
    @Test
    void validateCarNames5() {
        assertThatThrownBy(() -> CarNameValidator.validateCarNamesInput(","))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CarNameValidator.validateCarNamesInput(",,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름을 하나만 입력한 경우 예외 발생")
    @Test
    void validateCarNames6() {
        assertThatIllegalArgumentException().isThrownBy(() -> CarNameValidator.validateCarNamesInput("test"));
    }

    @DisplayName("같은 이름을 입력한 경우 예외 발생")
    @Test
    void validateCarNames7() {
        assertThatIllegalArgumentException().isThrownBy(() -> CarNameValidator.validateCarNamesInput("test,test,abc"));
    }

    @DisplayName("게임 진행 총 횟수로 1 이상의 숫자를 입력하면 정상 처리")
    @Test
    void validateTotalRound1() {
        assertThat(TotalRoundValidator.validateTotalRound("3")).isEqualTo(3);
    }

    @DisplayName("게임 진행 총 횟수 문자열 입력 시 예외 발생")
    @Test
    void validateTotalRound2() {
        assertThatThrownBy(() -> TotalRoundValidator.validateTotalRound("a"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> TotalRoundValidator.validateTotalRound("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 진행 총 횟수 0 입력 시 예외 발생")
    @Test
    void validateTotalRound3() {
        assertThatIllegalArgumentException().isThrownBy(() -> TotalRoundValidator.validateTotalRound("0"));
    }
}