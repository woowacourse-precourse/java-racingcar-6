package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScriptTest {
    final private Script script = new Script();
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUpOutputStream() {
        outputStream = new ByteArrayOutputStream();     //콘솔 출력 테스트 -> OutputStream 생성 후 설정
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoresOutputStream() {
        System.setOut(System.out);
    }

    @Test
    void 우승자_출력() {
        List<String> cars = List.of("carA", "carB", "carC", "carD");
        String result = "최종 우승자 : " + String.join(", ", cars);

        script.showWinner(cars);

        assertEquals(result, outputStream.toString());
    }

    @Test
    void 이동_결과_출력() {
        List<String> cars = List.of("carA", "carB", "carC");
        List<StringBuilder> moves = List.of(
                new StringBuilder("--"),
                new StringBuilder("----"),
                new StringBuilder("-")
        );

        StringBuilder result = new StringBuilder();

        for (int index = 0; index < cars.size(); index++) {
            result.append(cars.get(index) + " : " + moves.get(index)).append("\n");
        }
        result.append("\n");

        script.showResult(cars, moves);

        assertEquals(result.toString(), outputStream.toString());
    }
}
