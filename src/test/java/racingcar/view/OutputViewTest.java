package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

class OutputViewTest {

    private final OutputView outputView = new OutputView();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUpOutputStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreOutputStreams() {
        System.setOut(standardOut);
        outputStream.reset();
    }

    protected String getOutputStream() {
        return outputStream.toString().trim();
    }

    @Test
    @DisplayName("게임 시작 문구를 정상적으로 출력하는지 확인")
    void print_게임_시작_문구를_정상적으로_출력하는지_확인() {
        String startGameString = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

        outputView.printStartGame();

        assertThat(getOutputStream()).isEqualTo(startGameString);
    }

    @Test
    @DisplayName("시도 횟수 문구를 정상적으로 출력하는지 확인")
    void print_시도_횟수_문구를_정상적으로_출력하는지_확인() {
        String askAttemptString = "시도할 회수는 몇회인가요?";

        outputView.printAskAttempt();

        assertThat(getOutputStream()).isEqualTo(askAttemptString);
    }

    @Test
    @DisplayName("실행 결과 문구를 정상적으로 출력하는지 확인")
    void print_실행_결과_문구를_정상적으로_출력하는지_확인() {
        String gameResultString = "실행 결과";

        outputView.printGameResult();

        assertThat(getOutputStream()).isEqualTo(gameResultString);
    }

    @Test
    @DisplayName("최종 우승자 문구를 정상적으로 출력하는지 확인")
    void print_최종_우승자_문구를_정상적으로_출력하는지_확인() {
        String winnerNames = "pobi, jun";
        String finalWinnerString = String.format("최종 우승자 : %s", winnerNames);

        outputView.printFinalWinner(winnerNames);

        assertThat(getOutputStream()).isEqualTo(finalWinnerString);
    }

    @Test
    @DisplayName("실행 결과 사용자 순위를 정상적으로 출력하는지 확인")
    void print_실행_결과_사용자_순위를_정상적으로_출력하는지_확인() {
        List<String> names = List.of("pobi", "woni", "jun");
        String rankString = "pobi : \r\nwoni : \r\njun :";
        Cars cars = Cars.of(names);

        outputView.printRank(cars);

        assertThat(getOutputStream()).isEqualTo(rankString);
    }
}