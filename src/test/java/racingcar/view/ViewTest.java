package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ViewTest {
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setupStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("자동차 이름 질문 테스트")
    void askCarNameTest() {
        View.askCarName();
        assertThat(outputMessage.toString().trim())
                .isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    @DisplayName("카운트 입력 질문 테스트")
    void askCountTest() {
        View.askCount();
        assertThat(outputMessage.toString().trim())
                .isEqualTo("시도할 회수는 몇회인가요?");
    }

    @Test
    @DisplayName("레이스 실행 문장 테스트")
    void startRaceTest() {
        View.nextLine();
        assertThat(outputMessage.toString())
                .isEqualTo(System.lineSeparator());
        View.startRace();
        assertThat(outputMessage.toString().trim())
                .isEqualTo("실행 결과");
    }

    @Test
    @DisplayName("각 회수에 따른 출력 결과 테스트")
    void printResultTest() {
        List<String> userName = new ArrayList<>();
        List<Integer> distance = new ArrayList<>();
        String result = "pobi : ---" + System.lineSeparator() + "woni : ----"
                + System.lineSeparator() + System.lineSeparator();
        userName.add("pobi");
        userName.add("woni");
        distance.add(0, 3);
        distance.add(1, 4);
        View.printResult(userName, distance);
        assertThat(outputMessage.toString())
                .isEqualTo(result);
    }

    @Test
    @DisplayName("우승자 출력 테스트")
    void plusWinnerTest() {
        assertThat(View.plusWinner("", "pobi"))
                .isEqualTo("pobi");
        assertThat(View.plusWinner("pobi", "woni"))
                .isEqualTo("pobi, woni");
    }

    @Test
    @DisplayName("우승자 계산 테스트")
    void printWinnerTest() {
        List<String> userName = new ArrayList<>();
        List<Integer> distance = new ArrayList<>();
        Integer winnerDistance = 4;

        userName.add("pobi");
        userName.add("woni");
        userName.add("jun");
        distance.add(0, 3);
        distance.add(1, 4);
        distance.add(2, 4);
        View.printWinner(userName, distance, winnerDistance);
        assertThat(outputMessage.toString().trim())
                .isEqualTo("최종 우승자 : woni, jun");
    }
}
