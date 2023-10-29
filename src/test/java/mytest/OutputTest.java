package mytest;

import org.junit.jupiter.api.Test;
import view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import static org.assertj.core.api.Assertions.assertThat;
import static view.OutputView.displayRaceResult;

public class OutputTest {

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
