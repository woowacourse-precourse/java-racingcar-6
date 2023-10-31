package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingGameViewTest {
    RacingGameView racingGameView = new RacingGameView();
    @Test
    void showCarNameInputMessage_ShowMessage_SameMessage() {
        // 콘솔 출력을 캡처하기 위한 임시 출력 스트림 설정
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
        racingGameView.showCarNameInputMessage();

        assertThat(outContent.toString()).isEqualTo(expectedOutput);

    }

    @Test
    void printFinalWinners_ShowWinners_SameResult() {
        List<String> winnerList = Arrays.asList("Car1", "Car2", "Car3");

        // 콘솔 출력을 캡처하기 위한 임시 출력 스트림 설정
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // 테스트 대상 메서드 호출
        racingGameView.printFinalWinners(winnerList);

        // 예상 출력 문자열
        String expectedOutput = "최종 우승자 : Car1, Car2, Car3";

        // 캡처한 콘솔 출력과 예상 출력을 비교
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }
}