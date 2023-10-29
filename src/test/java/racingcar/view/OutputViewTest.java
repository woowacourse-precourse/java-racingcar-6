package racingcar.view;

import static org.assertj.core.api.Assertions.*;

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
        assertThat(outputStream.toString()).isEqualTo("car1 : -\ncar2 : \n");
    }

    @Test
    void 우승자_출력_단독() {
        //given
        List<String> winner = new ArrayList<>();
        winner.add("car");

        //when
        OutputView outputView = new OutputView();
        outputView.winners(winner);

        //then
        assertThat(outputStream.toString()).isEqualTo("최종 우승자 : car");
    }

    @Test
    void 우승자_출력_공동() {
        //given
        List<String> winner = new ArrayList<>();
        winner.add("car1");
        winner.add("car2");

        //when
        OutputView outputView = new OutputView();
        outputView.winners(winner);

        //then
        assertThat(outputStream.toString()).isEqualTo("최종 우승자 : car1, car2");
    }
}
