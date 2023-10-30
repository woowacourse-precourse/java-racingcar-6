package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.printer.MockPrinter;

class OutputViewTest {

    @Test
    @DisplayName("위치 현황의 타이틀 출력 기능 테스트")
    void printRacingResultTitleTest() {
        MockPrinter printer = new MockPrinter();
        OutputView outputView = new OutputView(printer);
        String expectedMessage = String.format("%n실행 결과");

        outputView.printRacingResultTitle();

        assertThat(printer.getPrintedMessage()).isEqualTo(expectedMessage);
    }

}
