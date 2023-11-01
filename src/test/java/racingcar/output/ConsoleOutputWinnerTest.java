package racingcar.output;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.Car;

class ConsoleOutputWinnerTest {

    private Output consoleOutput = new ConsoleOutput();

    @ParameterizedTest
    @MethodSource("provideCarList")
    @DisplayName("차수별 실행 결과 출력")
    void 차수별_실행_결과_출력(List<Car> carList, String result) {
        assertThat(run(carList)).contains(result);
    }

    static Stream<Arguments> provideCarList() {
        return PrintWinnerTestCase.getArgumentsStream();
    }

    private String run(List<Car> carList) {
        OutputStream print = new ByteArrayOutputStream();
        System.setOut(new PrintStream(print));

        consoleOutput.printWinner(carList);
        return print.toString();
    }

    //Reflection 활용
    private static Car createTestCar(String name, int distance) {
        Car car = new Car(name);
        try {
            Field field = Car.class.getDeclaredField("distance");
            field.setAccessible(true);
            field.set(car, distance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return car;
    }
}