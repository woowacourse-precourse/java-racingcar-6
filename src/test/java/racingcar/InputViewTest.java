package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.util.List;

public class InputViewTest {
    private final InputView inputView = new InputView();

    @Test
    void 자동차이름_입력값_분리_테스트() {
        List<String> inputViewList = inputView.splitInputByComma("minjun, dahyeong, jason");
        assertThat(inputViewList.size()).isEqualTo(3);
    }

    @Test
    void 자동차이름_공백_제거_테스트() {
        List<String> inputViewList = inputView.splitInputByComma(" minjun , dahyeong, jason ");
        assertThat(inputViewList.get(0).length()).isEqualTo(6);
    }
}
