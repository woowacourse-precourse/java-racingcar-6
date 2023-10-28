package racingcar.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.missionutils.Console;

class InputViewTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("자동차 이름을 성공적으로 입력 받으면, 각 자동차 이름을 원소로 가지는 리스트를 반환한다.")
    @Test
    void readCarNames_Success() {
        // given
        System.setIn(createUserInput("pobi,woni,jun"));

        // when, then
        Assertions.assertThat(InputView.readCarNames()).isEqualTo(List.of("pobi", "woni", "jun"));
    }

    @DisplayName("사용자로부터 입력 받은 자동차 이름이 입력 형식과 일치하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", ",pobi", "pobi,", "pobi, woni", ", pobi", "pobi,,", "pobi, ,", " "})
    void readCarName_Fail_ByInvalidCarNamesRegex(String invalidInput) {
        // given
        System.setIn(createUserInput(invalidInput));

        // when, then
        Assertions.assertThatThrownBy(InputView::readCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수를 정상적으로 입력 받으면, 그 값을 반환한다.")
    @Test
    void readNumberOfAttempts_Success() {
        // given
        System.setIn(createUserInput("1"));

        // when, then
        Assertions.assertThat(InputView.readNumberOfAttempts()).isEqualTo(1);
    }

    @DisplayName("사용자로부터 입력 받은 시도 횟수가 양의 정수가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "-", "!", "@"})
    void readNumberOfAttempts_Fail_ByNotInteger(String invalidInput) {
        // given
        System.setIn(createUserInput(invalidInput));

        // when, then
        Assertions.assertThatThrownBy(InputView::readNumberOfAttempts)
                .isInstanceOf(IllegalArgumentException.class);
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}