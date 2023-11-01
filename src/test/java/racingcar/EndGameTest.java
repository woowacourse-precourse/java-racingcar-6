package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

public class EndGameTest {

    RacingCar test = new RacingCar();

    @Test
    public void testGetMaxValue(){

        test.playersMap.put("aa", "----");
        test.playersMap.put("bb", "---");
        test.playersMap.put("cc", "-------");
        test.playersMap.put("dd", "--");

        int result = test.getMaxValue();

        assertThat(result).isEqualTo(7);
    }

    @Test
    void testGetWinner(){

        test.playersMap.put("aa", "----");
        test.playersMap.put("bb", "---");
        test.playersMap.put("cc", "-------");
        test.playersMap.put("dd", "--");

        test.getWinner(7);

        assertThat(test.winnerList).containsExactly("cc");

        test.winnerList.clear();
        test.playersMap.clear();

        test.playersMap.put("aa", "----");
        test.playersMap.put("bb", "----");
        test.playersMap.put("cc", "--");
        test.playersMap.put("dd", "-");

        test.getWinner(4);

        assertThat(test.winnerList).containsExactly("aa", "bb");
    }

    @Test
    public void testPrintOnlyWinner(){

        test.winnerList.add("aa");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        test.printWinner();
        String resultOnlyWinner = outputStream.toString().trim();

        assertThat(resultOnlyWinner).isEqualTo("최종 우승자 : aa");
    }

    @Test
    void testPrintMultiWinner(){

        test.winnerList.add("aa");
        test.winnerList.add("bb");
        test.winnerList.add("cc");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        test.printWinner();
        String resultMultiWinner = outputStream.toString().trim();

        assertThat(resultMultiWinner).isEqualTo("최종 우승자 : aa, bb, cc");
    }
}
