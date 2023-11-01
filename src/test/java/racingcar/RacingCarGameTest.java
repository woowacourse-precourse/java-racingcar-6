package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class RacingCarGameTest {
    @DisplayName("입력받은 자동차 이름을 쉼표(,) 기준으로 나누는 테스트")
    @Test
    void splitGamePlayers() {
        assertThat(RacingCarGame.splitGamePlayers("a,b")).containsExactly("a", "b");
        assertThat(RacingCarGame.splitGamePlayers("a, b")).containsExactly("a", " b");
    }

    @DisplayName("자동차 이름 길이의 5자 초과 여부 테스트")
    @Test
    void validateCarNameLength() {
        List<String> carNamesListForPass = Arrays.asList(new String[]{"1", "12", "123", "1234", "12345"});
        List<String> carNamesListForException = Arrays.asList(new String[]{"1", "5자초과이름"});

        assertThat(RacingCarGame.validateCarNameLength(carNamesListForPass)).isTrue();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingCarGame.validateCarNameLength(carNamesListForException);
        });
    }

    @DisplayName("자동차 이름이 없거나(blank) 공백으로만 이루졌는지 여부 테스트 ")
    @Test
    void validateCarNameBlankness() {
        List<String> carNamesListForPass = Arrays.asList(new String[]{"동훈", "영준이", "pobi"});
        List<String> carNamesListForException1 = Arrays.asList(new String[]{""});
        List<String> carNamesListForException2 = Arrays.asList(new String[]{" "});

        assertThat(RacingCarGame.validateCarNameBlankness(carNamesListForPass)).isTrue();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingCarGame.validateCarNameBlankness(carNamesListForException1);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingCarGame.validateCarNameBlankness(carNamesListForException2);
        });
    }

    @DisplayName("자동차 이름 길이의 5자 초과 여부 테스트")
    @Test
    void validateCarNameRepetition() {
        List<String> carNamesListForPass = Arrays.asList(new String[]{"sss", "a", "abs"});
        List<String> carNamesListForException = Arrays.asList(new String[]{"man", "man"});

        assertThat(RacingCarGame.validateCarNameRepetition(carNamesListForPass)).isTrue();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingCarGame.validateCarNameRepetition(carNamesListForException);
        });
    }

    @DisplayName("입력받은 이동 횟수 String을 int로 바꾸는 테스트")
    @Test
    void convertStringToInt() {
        assertThat(RacingCarGame.convertStringToInt("1")).isEqualTo(1);
        assertThat(RacingCarGame.convertStringToInt("2147483647")).isEqualTo(2147483647);
        assertThat(RacingCarGame.convertStringToInt("-1")).isEqualTo(-1);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingCarGame.convertStringToInt("2147483648");
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingCarGame.convertStringToInt("1.5");
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingCarGame.convertStringToInt(" ");
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingCarGame.convertStringToInt("숫자가 아니면 변환 불가");
        });
    }

    @DisplayName("0 이하의 정수가 입력되면 에러 발생하는 테스트")
    @Test
    void validateTrialNumberRange() {
        assertThat(RacingCarGame.validateTrialNumberRange(123)).isTrue();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingCarGame.validateTrialNumberRange(-1);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingCarGame.validateTrialNumberRange(0);
        });
    }
}