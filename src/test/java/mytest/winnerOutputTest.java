package mytest;

import org.junit.jupiter.api.Test;
import view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class winnerOutputTest {
    @Test
    void 우승자_한명_출력테스트() {
        //given
        ArrayList<String> winners = new ArrayList<>();
        winners.add("a");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //when
        OutputView.displayWinners(winners);
        System.setOut(System.out);

        //then
        String expectedOutput = "최종 우승자 : a";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    void 우승자_여러명_출력테스트() {
        //given
        ArrayList<String> winners = new ArrayList<>();
        winners.add("a");
        winners.add("b");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        //when
        System.setOut(new PrintStream(outContent));
        OutputView.displayWinners(winners);
        System.setOut(System.out);

        //then
        String expectedOutput = "최종 우승자 : a, b";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

}
