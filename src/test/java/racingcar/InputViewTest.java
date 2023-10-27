package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {
    private final InputView inputView = new InputView();

    void setSystemInToCustomInput(String customInput) {
        System.setIn(new ByteArrayInputStream(customInput.getBytes()));
        inputView.closeConsole();
    }

    @Test
    void 자동차이름_올바른_입력_테스트() {
        setSystemInToCustomInput("song, jone , jason");
        assertThatNoException().isThrownBy(() -> inputView.getCarList());
    }
    @Test
    void 자동차이름_입력값_공백_예외처리_테스트() {
        setSystemInToCustomInput("song, , jason");
        assertThatThrownBy(() -> inputView.getCarList()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_입력값_분리_테스트() {
        List<String> inputViewList = inputView.splitInputByComma("song, jone, jason");
        assertThat(inputViewList.size()).isEqualTo(3);
    }

    @Test
    void 자동차이름_공백_제거_테스트() {
        List<String> inputViewList = inputView.splitInputByComma(" song , jone, jason ");
        assertThat(inputViewList.get(0).length()).isEqualTo(4);
    }
}
