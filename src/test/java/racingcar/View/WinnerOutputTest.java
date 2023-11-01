package racingcar.View;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinnerOutputTest {
    WinnerOutput winnerOutput =new WinnerOutput();
    @Test
    void soloWinner() {

        List<String> testWinnerList = new ArrayList<>(List.of("car1"));


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        winnerOutput.soloWinner(testWinnerList);

        String output = outputStream.toString();
        String expectedString = "최종 우승자 : car1";


        assertEquals(expectedString,output);
    }

    @Test
    void multiWinner() {

        List<String> testWinnerList = new ArrayList<>(List.of("car1","car2"));


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        winnerOutput.multiWinner(testWinnerList);

        String output = outputStream.toString();


        assertThat(output).contains("car1","car2");
    }

    @Test
    void multiWinnerOutputForm() {

        List<String> testWinnerList = new ArrayList<>(List.of("car1","car2"));


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        winnerOutput.multiWinnerOutputForm(testWinnerList);

        String output = outputStream.toString();
        String[] expectedArray = output.split(", ");


        assertThat(expectedArray).contains("car1","car2");
    }
}