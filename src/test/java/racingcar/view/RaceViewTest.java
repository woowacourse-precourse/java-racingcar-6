package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RaceViewTest {

    private static ByteArrayOutputStream outputStream;
    private RaceView raceView = new RaceView();

    @BeforeEach
    void setUpStreams() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("자동차 이름 입력 안내 문구 출력")
    void printInputCarname() {
        raceView.printInputCarname();
        String message = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        assertThat(message).isEqualTo(outputStream.toString().trim());
    }

    @Test
    @DisplayName("시도 횟수 입력 안내 문구 출력")
    void printInputMoveTrialCount() {
        raceView.printInputMoveTrialCount();
        String message = "시도할 회수는 몇회인가요?";
        assertThat(message).isEqualTo(outputStream.toString().trim());
    }

    @Test
    @DisplayName("실행 결과 안내 문구 출력")
    void printExecutionResult() {
        raceView.printExecutionResult();
        String message = "실행 결과";
        assertThat(message).isEqualTo(outputStream.toString().trim());
    }

    @Test
    @DisplayName("최종 우승자 안내 문구 출력")
    void printFinalWinner() {
        List<String> winners = List.of("pobi", "woni");
        raceView.printFinalWinner(winners);
        String message = "최종 우승자 : pobi, woni";
        assertThat(message).isEqualTo(outputStream.toString().trim());
    }

    @Test
    @DisplayName("경주 현황 출력")
    void printProgress() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        pobi.forward();
        pobi.forward();
        woni.forward();
        jun.forward();

        raceView.printProgress(List.of(pobi, woni, jun));
        String message = "pobi : --\r\n" + "woni : -\r\n" + "jun : -";
        assertThat(message).isEqualTo(outputStream.toString().trim());
    }
}