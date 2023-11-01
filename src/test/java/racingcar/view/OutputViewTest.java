package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.enums.OutputMessage;

class OutputViewTest {

    private final OutputView outputView;
    private PrintStream standardOut;
    private OutputStream captor;

    OutputViewTest() {
        this.outputView = new OutputView();
    }

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @Test
    void 원하는_메시지_출력() {
        String message = "원하는 메시지";
        outputView.printMessage(message);
        assertEquals(output(), (message));
    }

    @Test
    void 게임_종료_안내_메시지_출력() {
        OutputView.printGameResultInfo();
        assertEquals(output(), OutputMessage.GAME_RESULT_INFO_MESSAGE.getValue());
    }

    @Test
    void 여러_자동차_단위_게임_결과_출력() {
        List<Car> cars = Arrays.asList(
                new Car("m"),
                new Car("o")
        );
        cars.get(0).move();
        OutputView.printUnitGameResult(cars);

        assertThat(output().contains("m : -") || output().contains("m : \n"));
        assertThat(output().contains("o : \n"));
    }

    @Test
    void 하나의_자동차_위치_출력() {
        Car car = new Car("m");
        IntStream.range(0, 3).forEach(i -> car.move());
        String position = "-".repeat(Math.max(0, car.getPosition()));

        OutputView.printUnitGameResult(new ArrayList<>(List.of(car)));
        assertEquals(output(), "m : " + position);
    }

    @Test
    void 승자_출력() {
        List<Car> cars = Arrays.asList(
                new Car("m"),
                new Car("o")
        );
        OutputView.printWinners(cars);
        assertEquals(output(), "최종 우승자 : m, o");
    }
}