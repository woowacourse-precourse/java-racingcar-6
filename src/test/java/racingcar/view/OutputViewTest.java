package racingcar.view;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    static OutputView outputView;
    @BeforeAll
    static void initOutputView() {
        outputView = new OutputView();
    }

    @Test
    @DisplayName("이동 출력 테스트: 정상 출력")
    void testOutputMoveResult() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        outputView.outputMoveResult("pobi", "---");
        outputView.outputMoveResult("java", "-");
        String testString = "pobi : ---\njava : -\n";
        assertThat(output.toString()).isEqualTo(testString);
    }

    @Test
    @DisplayName("결과 출력 테스트 - 단독 우승 : 정상 출력")
    void testOutputRaceResultSoloWin() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        outputView.outputRaceResult(List.of("pobi"));
        String testString = "최종 우승자 : pobi";
        assertThat(output.toString()).isEqualTo(testString);
    }

    @Test
    @DisplayName("결과 출력 테스트 - 공동 우승 : 정상 출력")
    void testOutputRaceResultJointWin() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        outputView.outputRaceResult(List.of("pobi", "java"));
        String testString = "최종 우승자 : pobi, java";
        assertThat(output.toString()).isEqualTo(testString);
    }
}
