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
                        "pobi", "woni"), new FixedCarEngine(true)
                )
        );
    }

    @DisplayName("Cars를 생성한다.")
    @ParameterizedTest
    @MethodSource("provideCarsTestArguments")
    void createTest(List<String> cars) {
        assertThatCode(() -> Cars.from(cars, new FixedCarEngine(true)))
                .doesNotThrowAnyException();
    }

    @DisplayName("자동차들의 엔진에 시동을 걸어서 움직일 수 있으면 1칸 전진한다.")
    @ParameterizedTest
    @MethodSource("provideCarsTestArguments")
    void moveSuccessTest(List<String> inputCarNames) {
        Cars cars = Cars.from(inputCarNames, new FixedCarEngine(true));
        List<Car> beforeMoveCars = cars.getCars();
        assertThat(beforeMoveCars.get(0).getPosition()).isEqualTo(0);
        assertThat(beforeMoveCars.get(1).getPosition()).isEqualTo(0);
        cars.move();
        List<Car> afterMoveCars = cars.getCars();
        assertThat(afterMoveCars.get(0).getPosition()).isEqualTo(1);
        assertThat(afterMoveCars.get(1).getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차들의 엔진에 시동을 걸어서 움직일 수 없으면 전진하지 않는다.")
    @ParameterizedTest
    @MethodSource("provideCarsTestArguments")
    void moveFailTest(List<String> inputCarNames) {
        Cars cars = Cars.from(inputCarNames, new FixedCarEngine(false));
        List<Car> beforeMoveCars = cars.getCars();
        assertThat(beforeMoveCars.get(0).getPosition()).isEqualTo(0);
        assertThat(beforeMoveCars.get(1).getPosition()).isEqualTo(0);
        cars.move();
        List<Car> afterMoveCars = cars.getCars();
        assertThat(afterMoveCars.get(0).getPosition()).isEqualTo(0);
        assertThat(afterMoveCars.get(1).getPosition()).isEqualTo(0);
    }

    @DisplayName("사용자가 입력한 자동차 이름으로 자동차객체를 생성한다.")
    @ParameterizedTest
    @MethodSource("provideAssembleTestArguments")
    void assembleTest(List<String> inputNames, Cars expectedCars) {
        Cars assembledCars = Cars.from(inputNames, new FixedCarEngine(true));
        List<Car> assembledCarList = assembledCars.getCars();
        List<Car> expectedCarList = expectedCars.getCars();
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
                        Cars.from(List.of("pobi", "woni", "jun"), new FixedCarEngine(true)),
                        List.of("pobi", "woni"),
                        Cars.from(List.of("pobi", "woni"), new FixedCarEngine(true)),
                        List.of("pobi"),
                        Cars.from(List.of("pobi"), new FixedCarEngine(true))
                )
        );
    }
}
