package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.IOTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

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
}