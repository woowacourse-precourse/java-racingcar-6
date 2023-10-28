package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    @DisplayName("InputView 생성자 테스트")
    @Test
    void InputViewConstructor() {
        //given
        //when
        //then
        assertThat(new InputView()).isNotNull();
    }

    @DisplayName("5자 이하의 자동차 이름 입력을 받으면 쉼표를 기준으로 자동차 이름을 분리하여 리스트로 반환한다.")
    @Test
    void inputCarNames() {
        //given
        //when
        String input = "pobi,woni,jun";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();
        List<String> cars = inputView.inputCarNames();
        //then
        assertThat(cars).isNotNull()
                .hasSize(3)
                .contains("pobi", "woni", "jun");
    }

    @DisplayName("5자를 초과한 자동차 이름 입력을 받으면 예외를 발생시킨다.")
    @Test
    void inputCarNameOver5() {
        //given
        //when
        String input = "pobi,woni,junyoung";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();

        //then
        assertThatThrownBy(inputView::inputCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @DisplayName("정상적인 범위의 시도 횟수를 입력받으면 시도 횟수를 반환한다.")
    @Test
    void inputTryCount() {
        //given
        //when
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();
        int tryCount = inputView.inputTryCount();
        //then
        assertThat(tryCount).isEqualTo(5);
    }

    @DisplayName("1 미만의 시도 횟수를 입력받으면 예외를 발생시킨다.")
    @Test
    void inputTryCountUnder1() {
        //given
        //when
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();
        //then
        assertThatThrownBy(inputView::inputTryCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @DisplayName("숫자가 아닌 시도 횟수를 입력받으면 예외를 발생시킨다.")
    @Test
    void inputTryCountNotNum() {
        //given
        //when
        String input = "안녕";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();
        //then
        assertThatThrownBy(inputView::inputTryCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("For input string: \"" + input + "\"");
    }

}