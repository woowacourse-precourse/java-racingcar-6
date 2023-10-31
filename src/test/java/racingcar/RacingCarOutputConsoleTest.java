package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.console.RacingCarConsole;

public class RacingCarOutputConsoleTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @Test
    void 최종_우승자_출력_1대_정상처리() {
        List<Car> carList = List.of(
                new Car("bae")
        );
        CarRacingResult carRacingResult = new CarRacingResult(carList);
        RacingCarConsole.printCarRacingResult(carRacingResult);

        assertThat(output()).isEqualTo("최종 우승자 : bae");
    }

    @Test
    void 최종_우승자_출력_2대_정상처리() {
        List<Car> carList = List.of(
                new Car("bae"),
                new Car("sue")
        );
        CarRacingResult carRacingResult = new CarRacingResult(carList);
        RacingCarConsole.printCarRacingResult(carRacingResult);

        assertThat(output()).isEqualTo("최종 우승자 : bae, sue");
    }

    @Test
    void 최종_우승자_출력_20대_영어_랜덤이름_정상처리() {
        Random random = new Random();
        List<String> nameList = IntStream.range(1, 20)
                .mapToObj(number ->
                        random.ints(97, 123)
                                .limit(5)
                                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                                .toString())
                .toList();

        StringBuilder expectedStringBuilder = new StringBuilder();
        expectedStringBuilder.append(nameList.get(0));
        for (int i = 1; i < nameList.size(); i++) {
            expectedStringBuilder.append(", ");
            expectedStringBuilder.append(nameList.get(i));
        }
        String expected = "최종 우승자 : " + expectedStringBuilder;

        List<Car> carList = nameList.stream()
                .map(Car::new)
                .toList();

        CarRacingResult carRacingResult = new CarRacingResult(carList);
        RacingCarConsole.printCarRacingResult(carRacingResult);

        assertThat(output()).isEqualTo(expected);
    }

    @Test
    void 경주_진행상황_출력_2대_정상처리() {
        List<Car> carList = List.of(
                new Car("bae"),
                new Car("sue")
        );
        carList.get(0).moveForward();
        RacingCarConsole.printProgressState(carList);

        assertThat(output()).isEqualTo("bae : -" + System.lineSeparator() + "sue :");
    }

    @Test
    void 경주_진행상황_출력_3대_정상처리() {
        List<Car> carList = List.of(
                new Car("bae"),
                new Car("sue")
        );
        carList.get(0).moveForward();
        carList.get(1).moveForward();
        carList.get(1).moveForward();
        RacingCarConsole.printProgressState(carList);

        assertThat(output()).isEqualTo("bae : -" + System.lineSeparator() + "sue : --");
    }
}
