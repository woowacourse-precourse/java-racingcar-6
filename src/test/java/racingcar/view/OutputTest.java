package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest {
    private final ByteArrayOutputStream os = new ByteArrayOutputStream();

    @BeforeEach
    void setOs() {
        System.setOut(new PrintStream(os));
    }

    @AfterEach
    void resetOs() {
        System.setOut(System.out);
        os.reset();
    }

    @Test
    void printCarResult_차가_간_거리_출력(){
        String expectedResult = "harry : ---";
        Output.printCarResult("harry", 3);
        assertThat(os.toString().strip()).isEqualTo(expectedResult);
    }

    @Test
    void printRaceResult_최종_우승자_출력(){
        String expectedResult = "최종 우승자 : harry, ron";
        List<String> names = new ArrayList<>();
        names.add("harry");
        names.add("ron");
        Output.printRaceResult(names);
        assertThat(os.toString().strip()).isEqualTo(expectedResult);
    }
}
