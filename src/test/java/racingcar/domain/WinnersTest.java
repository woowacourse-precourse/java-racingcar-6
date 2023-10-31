package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnersTest {
    private static final int NUMBER_OF_ADVANCE = 4;

    @Test
    @DisplayName("올바른 Winners 객체 생성 테스트")
    void correctInstanceCreationTest() {
        //given
        List<String> nameList = List.of("pobi", "java", "jigi");
        Cars cars = Cars.of(nameList);

        List<Car> carList = cars.getCarList();

        carList.get(0).accumulate(NUMBER_OF_ADVANCE);
        carList.get(1).accumulate(NUMBER_OF_ADVANCE);

        //when
        final Winners winners = Winners.of(cars);
        final List<String> winnerList = winners.getWinners().stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());

        //then
        assertThat(winnerList).contains("pobi", "java");
    }

    @Test
    @DisplayName("마지막 요소가 맞는지 확인하는 테스트")
    void checkLastElementTest() {
        //given
        List<String> nameList = List.of("pobi", "java", "jigi");
        Cars cars = Cars.of(nameList);

        Winners winners = Winners.of(cars);

        Car car = cars.getCarList().get(2);

        //when
        final boolean lastElement = winners.isLastCar(car);

        //then
        assertThat(lastElement).isTrue();
    }
}
