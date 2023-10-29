package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Game;

public class OutputViewTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setOutputStream() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreStream() {
        System.setOut(System.out);
        outputStream.reset();
    }

    @Test
    void 실행_결과_출력() {
        //given
        List<String> carName = new ArrayList<>();
        carName.add("car1");
        carName.add("car2");
        Game game = new Game(carName, 1);

        Car[] cars = game.getCars();

        cars[0].goForward();

        //when
        OutputView outputView = new OutputView();
        outputView.resultByRound(game);

        //then
        Assertions.assertThat(outputStream.toString()).isEqualTo("car1 : -\ncar2 : \n");
    }
}
