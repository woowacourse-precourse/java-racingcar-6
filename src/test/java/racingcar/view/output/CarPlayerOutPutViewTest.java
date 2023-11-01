package racingcar.view.output;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static resource.TestData.CAR_NAME_1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.CarPlayerModel;

public class CarPlayerOutPutViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void printPlayerPosition_출력_테스트() {
        CarPlayerModel car = new CarPlayerModel(CAR_NAME_1);
        CarPlayerModel spyCar = spy(car);
        doReturn(true).when(spyCar).isMoveAllowed();
        spyCar.move();

        CarPlayerOutPutView view = new CarPlayerOutPutView();
        view.printPlayerPosition(spyCar);

        String expectedOutput = (CAR_NAME_1 + " : -\n").trim();
        assertEquals(expectedOutput, outContent.toString().trim());
    }
}
