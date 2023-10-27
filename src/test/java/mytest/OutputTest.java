package mytest;

import org.junit.jupiter.api.Test;
import view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest {
    @Test
    void 레이스_실행결과_출력테스트() {
        HashMap<String, Integer> raceResult = new HashMap<>();
        raceResult.put("a", 1);
        raceResult.put("b", 3);
        raceResult.put("c", 2);

        //outContent로 표준 출력을 재지정.
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        OutputView.displayRaceResult(raceResult);
        //다시 원래의 표준으로 재지정
        System.setOut(System.out);

        String expectedOutput = "실행 결과\n" +
                "a : -\n" +
                "b : ---\n" +
                "c : --\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }
    @Test
    void 우승자_한명_출력테스트(){
        ArrayList<String> winners = new ArrayList<>();
        winners.add("a");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        OutputView.displayWinners(winners);
        System.setOut(System.out);

        String expectedOutput = "최종 우승자 : a";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    void 우승자_여러명_출력테스트(){
        ArrayList<String> winners = new ArrayList<>();
        winners.add("a");
        winners.add("b");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        OutputView.displayWinners(winners);
        System.setOut(System.out);

        String expectedOutput = "최종 우승자 : a, b";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

}
