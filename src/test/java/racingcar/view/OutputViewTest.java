package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.CarDto;

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
    void 자동차들_위치_포맷팅해_출력() {
        CarDto winnerCar = new CarDto("pobi", 3);
        CarDto nonWinnerCar = new CarDto("woni", 2);

        outputView.printAllCarPosition(List.of(winnerCar, nonWinnerCar));

        assertThat(outputStream.toString())
                .isEqualTo("pobi : ---\nwoni : --\n\n");
    }

    @Test
    void 우승_자동차_한대_일때_출력() {
        String winnerCarName = "pobi";

        outputView.printWinnerCar(List.of(winnerCarName));

        assertThat(outputStream.toString())
                .isEqualTo("최종 우승자 : pobi\n");
    }

    @Test
    void 우승_자동차_여러대_일때_포맷팅해_출력() {
        String winnerCarName = "pobi";
        String nonWinnerCarName = "woni";

        outputView.printWinnerCar(List.of(winnerCarName, nonWinnerCarName));

        assertThat(outputStream.toString())
                .isEqualTo("최종 우승자 : pobi, woni\n");
    }
}
