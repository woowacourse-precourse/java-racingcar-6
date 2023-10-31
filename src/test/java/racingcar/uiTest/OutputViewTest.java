package racingcar.uiTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.ui.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputViewTest {
    private OutputView outputView = new OutputView();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 경주_현황_출력_확인() {
        Car car = new Car("tayo");
        car.move(4);
        List<Car> cars = List.of(car);

        outputView.displayRaceStatus(cars);

        assertEquals("tayo : -", outputStream.toString().trim());
    }
}