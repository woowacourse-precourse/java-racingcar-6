package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.IOTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static racingcar.error.ErrorType.INVALID_ATTEMPT_COUNT_INPUT;

class GameInputViewTest extends IOTest {

    @DisplayName("경주 할 자동차들의 이름을 입력하라는 안내 문구가 출력되고 자동차들의 이름을 입력하면, 입력된 자동차들의 이름 리스트가 반환된다")
    @Test
    void printMessageToInputNamesOfCarsToRace_whenInputNamesOfCars_thenReturnNamesOfCars() {
        List<String> expectedResult = List.of("pobi", "woni", "jun");
        setInput(String.join(",", expectedResult));

        List<String> actualResult = GameInputView.inputCarNames();

        assertThat(output()).isEqualTo(GameInputView.INPUT_CAR_NAMES_MESSAGE);
        assertIterableEquals(expectedResult, actualResult);
    }

    @DisplayName("경주 할 자동차들의 이름을 입력하라는 안내 문구가 출력되고 5글자를 초과하는 자동차 이름을 입력하면, 예외가 발생한다.")
    @Test
    void printMessageToInputNamesOfCarsToRace_whenInputCarNameExceedsFiveCharacters_thenThrowException() {
        setInput("pobi,woogie");

        Throwable t = catchThrowable(GameInputView::inputCarNames);

        assertThat(output()).isEqualTo(GameInputView.INPUT_CAR_NAMES_MESSAGE);
        assertThat(t).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 회수를 입력하라는 안내 문구가 출력되고 시도 회수(정수)를 입력하면, 입력된 시도 회수가 반환된다.")
    @Test
    void printMessageToInputAttemptCount_whenInputAttemptCount_thenReturnAttemptCount() {
        int expectedResult = 5;
        setInput(String.valueOf(expectedResult));

        int actualResult = GameInputView.inputAttemptCount();

        assertThat(output()).isEqualTo(GameInputView.INPUT_ATTEMPT_COUNT_MESSAGE);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @DisplayName("시도 회수를 입력하라는 안내 문구가 출력되고 숫자가 아닌 값(문자)를 입력하면, 예외가 발생한다.")
    @Test
    void printMessageToInputAttemptCount_whenInputCharacters_thenReturnAttemptCount() {
        setInput("woowa");

        Throwable t = catchThrowable(GameInputView::inputAttemptCount);

        assertThat(output()).isEqualTo(GameInputView.INPUT_ATTEMPT_COUNT_MESSAGE);
        assertThat(t).isInstanceOf(IllegalArgumentException.class);
        assertThat(t.getMessage()).isEqualTo(INVALID_ATTEMPT_COUNT_INPUT.getMessage());
    }

    @DisplayName("시도 회수를 입력하라는 안내 문구가 출력되고 정수가 아닌 값(유리수)를 입력하면, 예외가 발생한다.")
    @Test
    void printMessageToInputAttemptCount_whenInputRationalNumber_thenReturnAttemptCount() {
        setInput("3.14");

        Throwable t = catchThrowable(GameInputView::inputAttemptCount);

        assertThat(output()).isEqualTo(GameInputView.INPUT_ATTEMPT_COUNT_MESSAGE);
        assertThat(t).isInstanceOf(IllegalArgumentException.class);
        assertThat(t.getMessage()).isEqualTo(INVALID_ATTEMPT_COUNT_INPUT.getMessage());
    }

    @DisplayName("시도 회수를 입력하라는 안내 문구가 출력되고 음의 정수를 입력하면, 예외가 발생한다.")
    @Test
    void printMessageToInputAttemptCount_whenInputMinusInteger_thenReturnAttemptCount() {
        setInput("-1");

        Throwable t = catchThrowable(GameInputView::inputAttemptCount);

        assertThat(output()).isEqualTo(GameInputView.INPUT_ATTEMPT_COUNT_MESSAGE);
        assertThat(t).isInstanceOf(IllegalArgumentException.class);
        assertThat(t.getMessage()).isEqualTo(INVALID_ATTEMPT_COUNT_INPUT.getMessage());
    }
}