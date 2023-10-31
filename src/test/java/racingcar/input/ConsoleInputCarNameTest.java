package racingcar.input;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.Car;
import racingcar.validator.Validator;

class ConsoleInputCarNameTest {

    private Input consoleInput = new ConsoleInput(new Validator());

    @ParameterizedTest
    @MethodSource("provideCarNames")
    @DisplayName("자동차 이름 입력 시 리스트 반환")
    void 자동차_이름_입력시_리스트_반환(String input) {
        List<String> carNameList = run(input).stream()
                .map(car -> String.valueOf(car.getName()))
                .toList();

        Arrays.stream(input.split(","))
                .forEach(carName -> assertThat(carNameList).contains(carName));
    }

    static Stream<Arguments> provideCarNames() {
        return IntStream.rangeClosed(1, 50)
                .mapToObj(input -> String.join(
                        ",",
                        IntStream.rangeClosed(1, input)
                                .mapToObj(i -> "DY" + i)
                                .toList()
                ))
                .map(Arguments::of);
    }

    private List<Car> run(String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        List<Car> cars = consoleInput.receiveCarNamesAndMakeList();

        Console.close();
        return cars;
    }
}