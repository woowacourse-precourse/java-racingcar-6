package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("올바른 Cars 객체 생성 테스트")
    void correctInstanceCreationTest() {
        //given
        List<String> nameList = List.of("pobi", "java");

        //when
        final Cars cars = Cars.of(nameList);
        final List<String> carList = cars.getCarList().stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());

        //then
        assertThat(carList).contains("pobi", "java");
    }
}
