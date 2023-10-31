package racingcar.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {
    private final InputView inputView = new InputView();

    @Test
    void 압력받은_자동차_이름_배열_반환() {
        assertThat(inputView.receiveCarNames("pobi,crong,honux")).contains("pobi", "crong", "honux");
    }

    @Test
    void 압력받은_시도_횟수_반환() {
        assertThat(inputView.receiveTotalRound("5")).isEqualTo(5);
    }
}