package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    void setSystemInToCustomInput(String customInput) {
        System.setIn(new ByteArrayInputStream(customInput.getBytes()));
        InputView.closeConsole();
    }

    @Test
    void 올바른_시도횟수_입력_테스트() {
        setSystemInToCustomInput("5");
        assertThatNoException().isThrownBy(InputView::getTrialNumber);
    }

    @Test
    void 올바른_자동차이름_입력_테스트() {
        setSystemInToCustomInput("song, jone , jason");
        assertThatNoException().isThrownBy(InputView::getCarsFromUser);
    }

    @Test
    void 중복된_자동차이름_예외처리_테스트() {
        assertThatThrownBy(() -> new Cars(List.of("mj", "mj"))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_입력값_공백_예외처리_테스트() {
        setSystemInToCustomInput("song, , jason");
        assertThatThrownBy(InputView::getCarsFromUser).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_입력값_분리_테스트() {
        List<String> inputViewList = InputView.splitInputByComma("song, jone, jason");
        assertThat(inputViewList.size()).isEqualTo(3);
    }

    @Test
    void 자동차이름_공백_제거_테스트() {
        List<String> inputViewList = InputView.splitInputByComma(" song , jone, jason ");
        assertThat(inputViewList.get(0).length()).isEqualTo(4);
    }
}
