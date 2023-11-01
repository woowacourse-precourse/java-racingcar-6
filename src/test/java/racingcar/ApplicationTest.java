package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.domain.StaticInputs;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.domain.Input.carNamesInputException;
import static racingcar.domain.Input.inputCountToInt;
import static racingcar.domain.Output.*;

class ApplicationTest extends NsTest {

    @BeforeAll
    public static void setup() {
        StaticInputs.intCount = 3;
        StaticInputs.carNamesArray = new String[]{"a", "b", "c"};
    }

    @Test
    void 글자수초과이름() {
        String[] arr = {"hi", "bye", "sayhihi"};
        assertThrows(IllegalArgumentException.class, () -> carNamesInputException(arr));
    }

    @Test
    void 입력횟수_숫자아님() {
        String input = "a";
        assertThrows(IllegalArgumentException.class, () -> inputCountToInt(input));
    }

    @Test
    public void 무작위수에대한막대기수() {
        int randomNumber = 5;
        String expectedOutput = "-----";

        String result = randomOutput(randomNumber);

        assertEquals(expectedOutput, result);
    }

    @Test
    public void 최대값구하기() {
        int[] arr = {1, 2, 3};
        int max = 3;
        int output = getMax(arr);
        assertEquals(max,output);
    }

    @Test
    void 최종우승자_출력확인() {
        String[] names = {"Car1", "Car2", "Car3"};
        int[] arr = {1, 3, 3};
        int max = 3;
        String expectedOutput = "최종 우승자 : Car2, Car3";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        getWinner(names, arr, max);

        String actualOutput = outputStream.toString().trim();

        System.setOut(System.out);

        assertEquals(expectedOutput, actualOutput);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


}
