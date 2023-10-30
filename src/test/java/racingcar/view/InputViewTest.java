package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class InputViewTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("자동차 이름 정상 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"lion,cat,dog"})
    void readCarNamesTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] expectedResult = new String[]{"lion", "cat", "dog"};
        assertThat(InputView.readCarNames()).containsExactly(expectedResult);
    }

    @DisplayName("자동차 경주 시도 횟수 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"123"})
    void readRacingTryCountTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(InputView.readRacingTryCount()).isEqualTo(123);
    }

    @DisplayName("자동차 경주 시드 횟수 잘못된 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"12a"})
    void readWrongRacingTryCountTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(InputView::readRacingTryCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 문자가 입력되었습니다.");
    }
}