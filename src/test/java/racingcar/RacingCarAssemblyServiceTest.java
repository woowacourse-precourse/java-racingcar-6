package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RacingCarAssemblyServiceTest {

    @DisplayName("사용자가 입력한 자동차 이름으로 자동차객체를 생성한다.")
    @ParameterizedTest
    @MethodSource("provideAssembleTestArguments")
    void assembleTest(List<String> inputNames, Cars expectedCars) {
        RacingCarAssemblyService racingCarAssemblyService = new RacingCarAssemblyService();
        Cars assembledCars = racingCarAssemblyService.assemble(inputNames);
        List<Car> assembledCarList = assembledCars.getReadOnlyCarList();
        List<Car> expectedCarList = expectedCars.getReadOnlyCarList();
        for (int i = 0; i < assembledCarList.size(); i++) {
            Car assembledCar = assembledCarList.get(i);
            Car expectedCar = expectedCarList.get(i);
            assertThat(assembledCar.getName()).isEqualTo(expectedCar.getName());
            assertThat(assembledCar.getPosition()).isEqualTo(expectedCar.getPosition());
        }
    }

    static Stream<Arguments> provideAssembleTestArguments() {
        return Stream.of(
                arguments(
                        List.of("pobi", "woni", "jun"),
                        new Cars(List.of(
                                new Car("pobi", new RandomCarEngine()),
                                new Car("woni", new RandomCarEngine()),
                                new Car("jun", new RandomCarEngine())
                        )),
                        List.of("pobi", "woni"),
                        new Cars(List.of(
                                new Car("pobi", new RandomCarEngine()),
                                new Car("woni", new RandomCarEngine())
                        )),
                        List.of("pobi"),
                        new Cars(List.of(
                                new Car("pobi", new RandomCarEngine())
                        ))
                )
        );
    }
}
