package racingcar.domain;

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

    static Stream<Arguments> provideCarsTestArguments() {
        return Stream.of(
                arguments(List.of(
                        setCar("test1", true),
                        setCar("test2", false)
                ))
        );
    }

    private static Car setCar(String carName, boolean engineCanMove) {
        return new Car(new CarName(carName), new FixedCarEngine(engineCanMove));
    }

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
        assertThat(afterMoveCar1.getCarName()).isEqualTo(inputCars.get(0).getCarName());
        Car afterMoveCar2 = afterMoveCars.get(1);
        assertThat(afterMoveCar2.getPosition()).isEqualTo(0);
        assertThat(afterMoveCars.get(1).getCarName()).isEqualTo(inputCars.get(1).getCarName());
    }

    @DisplayName("사용자가 입력한 자동차 이름으로 자동차객체를 생성한다.")
    @ParameterizedTest
    @MethodSource("provideAssembleTestArguments")
    void assembleTest(List<String> inputNames, Cars expectedCars) {
        Cars assembledCars = Cars.assemble(inputNames, new FixedCarEngine(true));
        List<Car> assembledCarList = assembledCars.getReadOnlyCarList();
        List<Car> expectedCarList = expectedCars.getReadOnlyCarList();
        for (int i = 0; i < assembledCarList.size(); i++) {
            Car assembledCar = assembledCarList.get(i);
            Car expectedCar = expectedCarList.get(i);
            assertThat(assembledCar.getCarName()).isEqualTo(expectedCar.getCarName());
            assertThat(assembledCar.getPosition()).isEqualTo(expectedCar.getPosition());
        }
    }

    static Stream<Arguments> provideAssembleTestArguments() {
        return Stream.of(
                arguments(
                        List.of("pobi", "woni", "jun"),
                        new Cars(List.of(
                                new Car(new CarName("pobi"), new FixedCarEngine(true)),
                                new Car(new CarName("woni"), new FixedCarEngine(true)),
                                new Car(new CarName("jun"), new FixedCarEngine(true))
                        )),
                        List.of("pobi", "woni"),
                        new Cars(List.of(
                                new Car(new CarName("pobi"), new FixedCarEngine(true)),
                                new Car(new CarName("woni"), new FixedCarEngine(true))
                        )),
                        List.of("pobi"),
                        new Cars(List.of(
                                new Car(new CarName("pobi"), new FixedCarEngine(true))
                        ))
                )
        );
    }
}
