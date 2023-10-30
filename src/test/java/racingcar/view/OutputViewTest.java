package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;
import racingcar.dto.RacingResultDto;
import racingcar.view.printer.MockPrinter;

class OutputViewTest {

    @Test
    @DisplayName("위치 현황의 타이틀 출력 기능 테스트")
    void printRacingResultTitleTest() {
        MockPrinter printer = new MockPrinter();
        OutputView outputView = new OutputView(printer);
        String expectedMessage = "%n실행 결과".formatted();

        outputView.printRacingResultTitle();

        assertThat(printer.getPrintedMessage()).isEqualTo(expectedMessage);
    }

    @Test
    @DisplayName("각 차수별 자동차 위치 현황 출력 기능 테스트")
    void printRacingResultTest() {
        MockPrinter printer = new MockPrinter();
        OutputView outputView = new OutputView(printer);
        RacingResultDto resultDto = new RacingResultDto(
                List.of(new CarDto("pobi", 3), new CarDto("woni", 2), new CarDto("jun", 3)));
        String expectedMessage = "pobi : ---%nwoni : --%njun : ---%n%n".formatted();

        outputView.printRacingResult(resultDto);

        assertThat(printer.getPrintedMessage()).isEqualTo(expectedMessage);
    }

}
