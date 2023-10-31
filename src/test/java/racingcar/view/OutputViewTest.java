package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;
import racingcar.dto.RacingResultDto;
import racingcar.dto.WinnerDto;
import racingcar.view.printer.MockPrinter;

class OutputViewTest {

    @Test
    @DisplayName("위치 현황의 타이틀 출력 기능 테스트")
    void printRacingResultTitleTest() {
        MockPrinter printer = new MockPrinter();
        OutputView outputView = new OutputView(printer);
        String expectedMessage = "%n실행 결과%n".formatted();

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

    @Nested
    @DisplayName("최종 우승자 출력 기능 테스트")
    class WinnerTest {

        @Test
        @DisplayName("한 명의 우승자를 출력할 수 있다")
        void printWinnerTest_whenWinnerIsOne() {
            MockPrinter printer = new MockPrinter();
            OutputView outputView = new OutputView(printer);
            WinnerDto winner = new WinnerDto(List.of("pobi"));
            String expectedMessage = "최종 우승자 : pobi";

            outputView.printWinner(winner);

            assertThat(printer.getPrintedMessage()).isEqualTo(expectedMessage);
        }

        @Test
        @DisplayName("한 명의 우승자를 출력할 수 있다")
        void printWinnerTest_whenWinnerIsMoreThan2() {
            MockPrinter printer = new MockPrinter();
            OutputView outputView = new OutputView(printer);
            WinnerDto winner = new WinnerDto(List.of("pobi", "jun"));
            String expectedMessage = "최종 우승자 : pobi, jun";

            outputView.printWinner(winner);

            assertThat(printer.getPrintedMessage()).isEqualTo(expectedMessage);
        }
    }



}
