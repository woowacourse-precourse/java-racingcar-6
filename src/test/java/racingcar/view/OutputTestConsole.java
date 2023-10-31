package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class OutputTestConsole extends NsConsoleIOTest {
    private static final int MOVING_FORWARD = 4;

    private Car generateCar(String name, int count) {
        Car car = new Car(name);

        for (int i = 0; i < count; i++) {
            car.runOrStop(MOVING_FORWARD);
        }

        return car;
    }

    @Test
    void printCurrentCar_정상출력() {
        // given
        List<Car> carList = Arrays.asList(
                generateCar("car1", 0),
                generateCar("car2", 2),
                generateCar("car3", 1)
        );

        // when
        Output output = new Output();
        output.printCurrentCar(carList);

        // then
        String expected =
                "car1 : " + System.lineSeparator() +
                        "car2 : --" + System.lineSeparator() +
                        "car3 : -" + System.lineSeparator() +
                        "" + System.lineSeparator();

        assertThat(getConsoleOutput()).isEqualTo(expected);
    }

    @Test
    void printFinalWinner_빈_List() {
        // given
        List<String> winnerNames = Arrays.asList();

        // when
        Output output = new Output();
        output.printFinalWinner(winnerNames);

        // then
        assertThat(getConsoleOutput()).isEqualTo("최종 우승자 : ");
    }

    @Test
    void printFinalWinner_공동_우승자() {
        // given
        List<String> winnerNames = Arrays.asList("pobi", "wooni");

        // when
        Output output = new Output();
        output.printFinalWinner(winnerNames);

        // then
        assertThat(getConsoleOutput()).isEqualTo("최종 우승자 : pobi, wooni");
    }

    @Test
    void printFinalWinner_단독_우승자() {
        // given
        List<String> winnerNames = Arrays.asList("ab");

        // when
        Output output = new Output();
        output.printFinalWinner(winnerNames);

        // then
        assertThat(getConsoleOutput()).isEqualTo("최종 우승자 : ab");
    }
}