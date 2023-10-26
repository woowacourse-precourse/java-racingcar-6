package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class InputViewTest {
    private final InputView inputView = new InputView();

    @Test
    void 자동차이름_입력값_분리_테스트() {
        List<inputView> inputViewList = inputView.splitByComma("minjun, dahyeong, jason");
        assertThat(inputViewList.size()).isEqualTo(3);
    }
}
