package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.view.OutputView;


public class OutputViewTest {

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("실행 결과 출력이 잘 진행되는지 확인")
    public void printPosition() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", 0),
                new Car("woni", 2)
        );

        OutputView.printPosition(cars.get(0));
        OutputView.printPosition(cars.get(1));

        String expectedOutputString = "pobi : " + System.lineSeparator() + "woni : --" + System.lineSeparator();
        assertThat(output.toString()).isEqualTo(expectedOutputString);

    }

    @Test
    @DisplayName("단독 우승자만이 존재할 경우 확인")
    public void printWinners_withOneWinner() {
        List<Car> winners = Arrays.asList(
                new Car("woni", 3)
        );

        OutputView.printWinners(winners);

        String expectedOutputString = "최종 우승자 : woni" + System.lineSeparator();
        assertThat(output.toString()).isEqualTo(expectedOutputString);
    }

    @Test
    @DisplayName("공동 우승자가 존재하는 경우 확인")
    public void printWinners_withSeveralWinners() {
        List<Car> winners = Arrays.asList(
                new Car("woni", 3),
                new Car("pobi", 3)
        );

        OutputView.printWinners(winners);

        String expectedOutputString = "최종 우승자 : woni,pobi" + System.lineSeparator();
        assertThat(output.toString()).isEqualTo(expectedOutputString);
    }


}
