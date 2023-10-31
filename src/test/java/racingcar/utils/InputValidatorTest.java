package racingcar.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputValidatorTest {
    public static InputValidator inputValidator;
    @BeforeAll
    public static void initializer(){
        inputValidator = new InputValidator();
    }

    @Test
    @DisplayName("이름_길이_유효성_검사_통과_테스트")
    void valid_validateNameOfLength() {
        // given
        Boolean isValid;
        String name = "pobie";
        // when
        isValid = inputValidator.validateNameOfLength(name);
        // then
        assertThat(isValid).isEqualTo(true);
    }

    @Test
    @DisplayName("이름_길이_유효성_검사_불통과_테스트")
    void invalid_validateNameOfLength() {
        // given
        Boolean isValid;
        String name = "seolhuigwan";
        // when
        isValid = inputValidator.validateNameOfLength(name);
        // then
        assertThat(isValid).isEqualTo(false);
    }

    @Test
    @DisplayName("이동_횟수_숫자형_통과_테스트")
    void valid_isNumericValid() {
        // given
        Boolean isValid;
        String moveCount = "5";
        // when
        isValid = inputValidator.isNumericValid(moveCount);
        // then
        assertThat(isValid).isEqualTo(true);
    }

    @Test
    @DisplayName("이동_횟수_숫자형_불통과_테스트")
    void invalid_isNumericValid() {
        // given
        Boolean isValid;
        String moveCount = "난 숫자가 아니야";
        // when
        isValid = inputValidator.isNumericValid(moveCount);
        // then
        assertThat(isValid).isEqualTo(false);
    }

    @Test
    @DisplayName("이동_횟수_최솟값_통과_테스트")
    void valid_isMinValueValid() {
        // given
        Boolean isValid;
        Integer moveCount = 5;
        // when
        isValid = inputValidator.isMinValueValid(moveCount);
        // then
        assertThat(isValid).isEqualTo(true);
    }

    @Test
    @DisplayName("이동_횟수_최솟값_불통과_테스트")
    void invalid_isMinValueValid() {
        // given
        Boolean isValid;
        Integer moveCount = 0;
        // when
        isValid = inputValidator.isMinValueValid(moveCount);
        // then
        assertThat(isValid).isEqualTo(false);
    }

    @Test
    @DisplayName("최소_자동차_개수_통과_테스트")
    void valid_validateNumberOfCar() {
        // given
        List<String> candidateCars = new ArrayList<>(Arrays.asList("pobie","woni"));
        Boolean isValid;
        // when
        isValid = inputValidator.validateNumberOfCar(candidateCars);
        // then
        assertThat(isValid).isEqualTo(true);
    }

    @Test
    @DisplayName("최소_자동차_개수_불통과_테스트")
    void invalid_validateNumberOfCar() {
        // given
        List<String> candidateCars = new ArrayList<>(Arrays.asList("pobie"));
        Boolean isValid;
        // when
        isValid = inputValidator.validateNumberOfCar(candidateCars);
        // then
        assertThat(isValid).isEqualTo(false);
    }

    @Test
    @DisplayName("이름_공백_불포함_통과_테스트")
    void valid_isNoSpaceValid() {
        // given
        String name = "pobie";
        Boolean isValid;
        // when
        isValid = inputValidator.isNoSpaceValid(name);
        // then
        assertThat(isValid).isEqualTo(true);
    }

    @Test
    @DisplayName("이름_공백_불포함_불통과_테스트")
    void invalid_isNoSpaceValid() {
        // given
        String name = "       pobie";
        Boolean isValid;
        // when
        isValid = inputValidator.isNoSpaceValid(name);
        // then
        assertThat(isValid).isEqualTo(false);
    }

    @Test
    @DisplayName("입력_NotNull_통과_테스트")
    void valid_isNotNullValid() {
        // given
        String input = "pobie,woni";
        Boolean isValid;
        // when
        isValid = inputValidator.isNotNullValid(input);
        // then
        assertThat(isValid).isEqualTo(true);
    }

    @Test
    @DisplayName("입력_NotNull_불통과_테스트")
    void invalid_isNotNullValid() {
        // given
        String input = "";
        Boolean isValid;
        // when
        isValid = inputValidator.isNotNullValid(input);
        // then
        assertThat(isValid).isEqualTo(false);
    }
}