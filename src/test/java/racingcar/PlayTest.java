package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

public class PlayTest {

    RacingCar test = new RacingCar();

    @Test
    public void testGetRandomValue(){

        for(int i=0;i<30;i++){
            int result = test.getRandomValue();
            assertThat(result).isLessThanOrEqualTo(9);
        }
    }

    @Test
    public void testJudgeMoveOrStop(){

        test.carsMap.put("go", "");
        test.carsMap.put("stop", "");

        test.judgeMoveOrStop("go", 4);
        test.judgeMoveOrStop("stop", 3);

        assertThat(test.carsMap.get("go")).isEqualTo("-");
        assertThat(test.carsMap.get("stop")).isEqualTo("");
    }

    @Test
    public void testPrintRoundResult(){

        test.carsMap.put("aa", "");
        test.carsMap.put("bb", "----");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        test.printRoundResult();
        String result = outputStream.toString().trim();

        assertThat(result).isEqualTo("aa : \nbb : ----");
    }
}
