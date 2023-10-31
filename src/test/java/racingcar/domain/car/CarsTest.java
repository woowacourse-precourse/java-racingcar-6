package racingcar.domain.car;

import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import racingcar.domain.stubgenerator.SequentialNumberGeneratorStub;

class CarsTest {

    Cars cars;

    @BeforeEach
    void init() {
        List<String> carNames = List.of("test", "test2","test3");
        cars = Cars.createCars(carNames, new SequentialNumberGeneratorStub(List.of(4,4,3)));
    }

    @Test
    @DisplayName("차들 움직임 테스트")
    void Cars_Move() {
        cars.move();

        List<Car> findCars = cars.getCars();
        List<Integer> positions = findCars.stream()
                .map(Car::getPosition)
                .toList();
        Assertions.assertThat(positions).isEqualTo(List.of(1,1,0));

    }

    @Test
    @DisplayName("승자 찾기 테스트")
    void 승자_찾기_테스트() {
        //when
        cars.move();
        List<Car> winner = cars.getWinner();
        List<String> names = winner.stream()
                .map(Car::getName)
                .toList();

        //then
        Assertions.assertThat(names).isEqualTo(List.of("test", "test2"));



    }



}