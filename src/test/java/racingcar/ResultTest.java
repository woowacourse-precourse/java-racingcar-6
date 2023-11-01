package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResultTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private Result result = new Result();

    @Test
    void printRacingProcess_자동차경주_진행과정의_출력이_올바른지() {
        Map<String, Integer> carNameAndMoving = new LinkedHashMap<>();
        carNameAndMoving.put("pobi", 3);
        carNameAndMoving.put("Ahn", 1);
        carNameAndMoving.put("Lee", 0);

        System.setOut(new PrintStream(outputStream));
        result.printRacingProcess(carNameAndMoving);

        String expectedResult = "pobi : ---\r\nAhn : -\r\nLee : \r\n\r\n";

        Assertions.assertThat(outputStream.toString()).isEqualTo(expectedResult);
    }

    @Test
    void printRacingWinner_자동차경주_결과의_출력이_올바른지() {
        Map<String, Integer> carNameAndMoving = new LinkedHashMap<>();
        carNameAndMoving.put("pobi", 2);
        carNameAndMoving.put("Ahn", 4);
        carNameAndMoving.put("Lee", 4);

        System.setOut(new PrintStream(outputStream));
        result.printRacingWinner(carNameAndMoving);

        String expectedResult = "최종 우승자 : Ahn, Lee";

        Assertions.assertThat(outputStream.toString()).isEqualTo(expectedResult);
    }
}
