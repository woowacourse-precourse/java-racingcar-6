package racingcar.util.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class OutputUtilsTest {

    @Test
    void 차_이동_출력_테스트(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        OutputUtils.printCarMove("pobi", 3);

        System.setOut(originalOut);

        assertEquals("pobi : ---\n", outputStream.toString());
    }
}
