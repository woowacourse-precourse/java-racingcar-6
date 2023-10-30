package racingcar.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest extends IOTest {

    @Test
    void outputGameResultMessage() {
        // given
        OutputView outputView = new OutputView();
        String expected = "실행 결과\n";
        // when
        outputView.outputGameResultMessage();
        // then
        assertThat(getOutput()).isEqualTo(expected);
    }

    @Test
    void outputCarsPosition() {
        // given
        // when
        // then
    }

    @Test
    void outputWinner() {
        // given
        // when
        // then
    }
}