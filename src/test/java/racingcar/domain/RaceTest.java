package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RaceTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUpOutputStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoreOutputStream() {
        System.setOut(System.out);
        output.reset();
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "woni"), "최종 우승자 : pobi"),
                Arguments.of(Arrays.asList("woni", "pobi"), "최종 우승자 : woni"));
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void 어떤_차가_우승했는지_확인(List<String> carNames, String expected) {
        List<Car> cars = new ArrayList<>();
        Car firstCar = new Car(carNames.get(0));
        Car secondCar = new Car(carNames.get(1));
        cars.add(firstCar);
        cars.add(secondCar);
        Race race = new Race(cars, 0);

        firstCar.moveForward(4);
        race.evaluate();

        assertThat(output.toString().trim()).isEqualTo(expected);
    }
}