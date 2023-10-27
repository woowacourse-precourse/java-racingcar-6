package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {
    private static final String BLANK_ERROR_MESSAGE = "자동차 이름은 공백값을 가질 수 없습니다.";

    @AfterEach
    public void init() {
        Console.close();
    }

    private void setSystemIn(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("정상적인 입력이면 자동차 이름 리스트 얻어야 한다.")
    @Test
    void getCarNameListTest() {
        // given
        String input = "pobi,lastcow,jason";
        setSystemIn(input);

        // when
        List<String> carNameList = InputView.getCarNameList();

        // then
        assertThat(carNameList).isEqualTo(Arrays.asList(input.split(",")));
    }

    @DisplayName("자동차 이름으로 공백을 입력 받으면 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "pobi,la tcow", "pobi, ,jason", "pobi ,jason", "pobi, jason,", "pobi,jason, La"})
    void validateBlankTest(String input) {
        // given
        setSystemIn(input);

        // when, then
        assertThatThrownBy(InputView::getCarNameList)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BLANK_ERROR_MESSAGE);
    }
}