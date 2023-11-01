package racingcar.util.validation.InputValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("사용자 입력 구분자 테스트")
    @Test
    void validateUserInput() {
        String wrongUserInput = "adsda";

        assertThatThrownBy(() -> {
            InputValidator.validateUserInput(wrongUserInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 입력 공백 테스트")
    @Test
    void validateUserInputListEmpty() {
        List<String> userInputList = new ArrayList<>();
        userInputList.add("aaa");
        userInputList.add("");

        assertThatThrownBy(() -> {
            InputValidator.validateUserInputList(userInputList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 입력 글자수 테스트 ")
    @Test
    void validateUserInputListNameLimit() {
        List<String> userInputList = new ArrayList<>();
        userInputList.add("aaa");
        userInputList.add("abcdef");

        assertThatThrownBy(() -> {
            InputValidator.validateUserInputList(userInputList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 입력 중복 테스트")
    @Test
    void validateUserInputListDuplicated() {
        List<String> userInputList = new ArrayList<>();
        userInputList.add("aaa");
        userInputList.add("aaa");

        assertThatThrownBy(() -> {
            InputValidator.validateUserInputList(userInputList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("경기 횟수 입력 테스트")
    @Test
    void validateRacingRound() {
        String racingRound = "4";
        int racingRoundNum = 4;

        int roundNum = InputValidator.validateRacingRound(racingRound);
        assertThat(roundNum).isEqualTo(racingRoundNum);
    }

    @DisplayName("경기 횟수 입력 오류 테스트")
    @Test
    void validateRacingRoundError() {
        String racingRound = "-5";

        assertThatThrownBy(() -> {
            InputValidator.validateRacingRound(racingRound);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}