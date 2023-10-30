package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    private OutputView outputView;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 자동차들_위치_출력시_포맷팅해_반환() {
        CarDto winnerCar = new CarDto("pobi",3);
        CarDto nonWinnerCar = new CarDto("woni", 2);

        outputView.printAllCarPosition(List.of(winnerCar, nonWinnerCar));

        assertThat(outputStream.toString())
                .isEqualTo("pobi : ---\nwoni : --\n\n");
    }
}
