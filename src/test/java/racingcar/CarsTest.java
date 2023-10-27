package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarsTest {

    @DisplayName("Cars를 생성한다.")
    @ParameterizedTest
    @MethodSource("provideCarsTestArguments")
    void createTest(List<Car> cars) {
        assertThatCode(() -> new Cars(cars))
                .doesNotThrowAnyException();
    }

    @DisplayName("자동차들의 엔진에 시동을 걸어서 움직일 수 있으면 1칸 전진, 움직일 수 없으면 전진하지 않는다.")
    @ParameterizedTest
    @MethodSource("provideCarsTestArguments")
    void moveTest(List<Car> inputCars) {
        Cars cars = new Cars(inputCars);
        cars.move();
        List<Car> afterMoveCars = cars.getReadOnlyCarList();
        Car afterMoveCar1 = afterMoveCars.get(0);
        assertThat(afterMoveCar1.getPosition()).isEqualTo(1);
        assertThat(afterMoveCar1.getName()).isEqualTo(inputCars.get(0).getName());
        Car afterMoveCar2 = afterMoveCars.get(1);
        assertThat(afterMoveCar2.getPosition()).isEqualTo(0);
        assertThat(afterMoveCars.get(1).getName()).isEqualTo(inputCars.get(1).getName());
    }

    static Stream<Arguments> provideCarsTestArguments() {
        return Stream.of(
                arguments(List.of(
                        setCar("test1", true),
                        setCar("test2", false)
                ))
        );
    }

    private static Car setCar(String carName, boolean engineCanMove) {
        return new Car(carName, new FixedCarEngine(engineCanMove));
    }
}
