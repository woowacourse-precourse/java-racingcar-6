package view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.CarPosition;
import racingcar.domain.Cars;
import racingcar.view.OutputView;

public class OutputViewTest {
    private static ByteArrayOutputStream outputCaptor;

    @BeforeEach
    void setUp() {
        outputCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCaptor));
    }

    @Test
    @DisplayName("올바른 위치를 출력한다.")
    void should_PrintCorrectPosition() {
        Cars cars = new Cars(List.of(
                new Car(new CarName("스폰지밥"), new CarPosition(5)),
                new Car(new CarName("뚱이"), new CarPosition(3)),
                new Car(new CarName("징징이"), new CarPosition(4))
        ));
        OutputView.printCurrentCarLocation(cars);
        assertThat(getOutput()).isEqualTo("스폰지밥 : -----\n뚱이 : ---\n징징이 : ----\n".trim());
    }

    @Test
    @DisplayName("우승자가 한명인 경우 한명의 우승자를 출력한다.")
    void should_PrintSingleWinner_When_WinnerIsSingle() {
        List<String> winner = List.of("손오공");
        OutputView.printWinners(winner);
        assertThat(getOutput()).isEqualTo("최종 우승자 : 손오공");
    }

    @Test
    @DisplayName("우승자가 여러명인 경우 여러명의 우승자를 출력한다.")
    void should_PrintMultipleWinners_When_WinnersAreMultiple() {
        List<String> winners = List.of("손오공", "크리링", "베지터");
        OutputView.printWinners(winners);
        assertThat(getOutput()).isEqualTo("최종 우승자 : 손오공, 크리링, 베지터");
    }

    String getOutput() {
        return outputCaptor.toString().trim();
    }

}
