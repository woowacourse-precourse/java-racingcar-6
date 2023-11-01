package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatus;
import racingcar.dto.RaceStatus;
import racingcar.dto.RacingGameResult;
import racingcar.dto.RacingGameStatus;
import racingcar.dto.WinnerNames;

class ConsoleOutputViewTest {
    ConsoleOutputView consoleOutputView = new ConsoleOutputView();
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setupStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoreStream() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    @DisplayName("자동차 이름 입력 메시지 테스트")
    void requestCarNamesTest() {
        ConsoleInputView consoleInputView = new ConsoleInputView();
        consoleOutputView.requestCarNames(consoleInputView.getDelimiterDescription(), consoleInputView.getDelimiter());
        assertThat(output.toString()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
    }

    @Test
    @DisplayName("시도 횟수 입력 메시지 테스트")
    void requestRaceCountTest() {
        consoleOutputView.requestRaceCount();
        assertThat(output.toString()).isEqualTo("시도할 회수는 몇회인가요?\n");
    }

    @Test
    @DisplayName("경주 결과 확인 메시지 테스트")
    void printRacingGameStatusTest() {
        CarStatus firstCarStatus = new CarStatus("1번", 3);
        CarStatus secondCarStatus = new CarStatus("2번", 2);
        CarStatus thirdCarStatus = new CarStatus("3번", 3);
        RaceStatus raceStatus = new RaceStatus(List.of(firstCarStatus, secondCarStatus, thirdCarStatus));

        RacingGameStatus racingGameStatus = new RacingGameStatus(List.of(raceStatus));
        WinnerNames winnerNames = new WinnerNames(List.of("1번", "3번"));
        RacingGameResult racingGameResult = new RacingGameResult(racingGameStatus, winnerNames);

        consoleOutputView.printRacingGameResult(racingGameResult);
        assertThat(output.toString()).isEqualTo(
                """
                        
                        실행 결과
                        1번 : ---
                        2번 : --
                        3번 : ---
                        
                        최종 우승자 : 1번, 3번
                        """
        );
    }
}