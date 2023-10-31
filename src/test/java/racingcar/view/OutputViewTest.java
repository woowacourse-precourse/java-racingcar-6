package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeAll
    static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    @DisplayName("자동차이름을 묻는 출력이 제대로 작동하는지 확인")
    void askCarName() {
        OutputView.askCarName();
        assertThat(outContent.toString()).contains("경주할 자동차 이름을 입력하세요");
    }

    @Test
    @DisplayName("게임 횟수를 묻는 출력이 제대로 작동하는지 확인")
    void askPlayTime() {
        OutputView.askPlayTime();
        assertThat(outContent.toString()).contains("시도할 회수는 몇회인가요");
    }

    @Test
    @DisplayName("실행 결과 출력이 제대로 작동하는지 확인")
    void showResultMessage() {
        OutputView.showResultMessage();
        assertThat(outContent.toString()).contains("실행 결과");
    }


}