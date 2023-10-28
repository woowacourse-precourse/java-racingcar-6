package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.FixedCarEngine;

public class RacingCarAssemblyServiceTest {

    static Stream<Arguments> provideAssembleTestArguments() {
        return Stream.of(
                arguments(
                        List.of("pobi", "woni", "jun"),
                        new Cars(List.of(
                                new Car("pobi", new FixedCarEngine(true)),
                                new Car("woni", new FixedCarEngine(true)),
                                new Car("jun", new FixedCarEngine(true))
                        )),
                        List.of("pobi", "woni"),
                        new Cars(List.of(
                                new Car("pobi", new FixedCarEngine(true)),
                                new Car("woni", new FixedCarEngine(true))
                        )),
                        List.of("pobi"),
                        new Cars(List.of(
                                new Car("pobi", new FixedCarEngine(true))
                        ))
                )
        );
    }

    @DisplayName("사용자가 입력한 자동차 이름으로 자동차객체를 생성한다.")
    @ParameterizedTest
    @MethodSource("provideAssembleTestArguments")
    void assembleTest(List<String> inputNames, Cars expectedCars) {
        RacingCarAssemblyService racingCarAssemblyService = new RacingCarAssemblyService();
        Cars assembledCars = racingCarAssemblyService.assemble(inputNames, new FixedCarEngine(true));
        List<Car> assembledCarList = assembledCars.getReadOnlyCarList();
        List<Car> expectedCarList = expectedCars.getReadOnlyCarList();
        for (int i = 0; i < assembledCarList.size(); i++) {
            Car assembledCar = assembledCarList.get(i);
            Car expectedCar = expectedCarList.get(i);
            assertThat(assembledCar.getName()).isEqualTo(expectedCar.getName());
            assertThat(assembledCar.getPosition()).isEqualTo(expectedCar.getPosition());
        }
    }
}
