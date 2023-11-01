package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputManagerTest {

    ByteArrayOutputStream outputStream;
    OutputManager outputManager;

    @BeforeEach
    public void beforeEach() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        outputManager = new OutputManager();
    }

    @Test
    void printCarStatus() {
        //given
        Map<String, Integer> carStatus = new LinkedHashMap<>();
        carStatus.put("pobi", 2);
        carStatus.put("woni", 4);
        carStatus.put("jun", 3);
        String expectedOutput = "pobi : --\n woni : ----\njun : ---\n";
        //when
        outputManager.printCarStatus(carStatus);
        System.setOut(System.out);
        String actualOutput = outputStream.toString().trim();
        //then
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }
}