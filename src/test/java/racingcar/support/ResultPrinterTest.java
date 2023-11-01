package racingcar.support;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.game.components.Car;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.message.GameMessages.WINNERS;

class ResultPrinterTest {

    private final ResultPrinter printer = new ResultPrinter();

    @Test
    @DisplayName("게임의_진행_상황을_형식에_맞게_출력한다.")
    void execute() {
        Car enzo = new Car("enzo");
        Car kai = new Car("kai");
        Car silva = new Car("silva");

        for (int i = 0; i < 5; i++) {
            enzo.move();
        }
        for (int i = 0; i < 2; i++) {
            kai.move();
        }
        for (int i = 0; i < 3; i++) {
            silva.move();
        }

        List<Car> carList = Arrays.asList(enzo, kai, silva);

        OutputStream out = getOutputStream();
        printer.execute(carList);

        String expectedValue =
                "enzo : -----" + System.lineSeparator() +
                        "kai : --" + System.lineSeparator() +
                        "silva : ---";
        assertThat(out.toString().trim()).isEqualTo(expectedValue);
    }

    private static OutputStream getOutputStream() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        return out;
    }

    @Test
    @DisplayName("정해진_양식으로_승리자를_출력한다.")
    void winner() {
        List<Car> winners = Arrays.asList(
                new Car("enzo"),
                new Car("kai")
        );
        OutputStream out = getOutputStream();
        printer.winner(winners);

        String expectedValue = WINNERS + "enzo, kai";

        assertThat(out.toString().trim()).isEqualTo(expectedValue);
    }
}