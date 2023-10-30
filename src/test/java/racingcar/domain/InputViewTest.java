package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewTest {

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    void getCarStrings_테스트() {
        // given
        InputStream inputStream = new ByteArrayInputStream("pobi, woni, ".getBytes());
        System.setIn(inputStream);
        // when
        List<String> carStrings = InputView.getCarStrings();
        // then
        assertThat(carStrings).containsExactly("pobi", " woni", " ");
    }

    @ParameterizedTest
    @CsvSource({"'pobi,,woni',[ERROR] 입력이 널이거나 빈 문자열입니다.",
            "'pobi,woni,',[ERROR] 입력의 끝이 구분자로 끝날 수 없습니다."})
    void getCarStrings_예외발생_테스트(String input, String errorMessage) {
        // given
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        // when, then
        assertThatThrownBy(InputView::getCarStrings)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    @Test
    void getMoveCount_테스트() {
        // given
        InputStream inputStream = new ByteArrayInputStream("10".getBytes());
        System.setIn(inputStream);
        // when
        int moveCount = InputView.getMoveCount();
        // then
        assertThat(moveCount).isEqualTo(10);
    }

    @ParameterizedTest
    @CsvSource({"1a,[ERROR] 입력이 숫자가 아닙니다.", "'\n',[ERROR] 입력이 널이거나 빈 문자열입니다."})
    void getMoveCount_예외발생_테스트(String input, String errorMessage) {
        // given
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        // when, then
        assertThatThrownBy(InputView::getMoveCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }
}