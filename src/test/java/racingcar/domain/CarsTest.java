package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("중복된 이름이 입력된 경우 예외 발생")
    void 예외_처리_테스트_1() {
        MovingStrategy movingStrategy = new MovingStrategy(new RandomNumberGenerator());
        List<String> names = Arrays.asList("pobi", "pobi", "crong", "horan");

        assertThrows(IllegalArgumentException.class,
                () -> {
                    new Cars(names, movingStrategy);
                });
    }

    @Test
    @DisplayName("Cars의 동차 저장 리스트 필드가 같은지 테스트")
    void getCars() {
        // given
        MovingStrategy movingStrategy = new MovingStrategy(new RandomNumberGenerator());
        List<String> names = Arrays.asList("pobi", "crong", "horan");

        // when
        Cars cars = new Cars(names, movingStrategy);
        List<Car> result = cars.getCars();
        List<Car> expected = Arrays.asList(new Car(movingStrategy, "pobi", 0),
                                        new Car(movingStrategy, "crong", 0),
                                        new Car(movingStrategy, "horan", 0));
        

        // then
        assertArrayEquals(expected, result);
    }



    @Test
    @DisplayName("자동차가 모두 전진하는 경우")
    void raceAllCars_전진() {
        // given
        MovingStrategy moveStrategy = new MovingStrategy(()->4);
        List<String> names = Arrays.asList("pobi", "crong", "horan");
        Cars cars = new Cars(names, moveStrategy);

        // when
        cars.raceAllCars();
        List<Car> result = cars.getCars();

        // then
        assertThat(result.stream()
                .allMatch(car -> car.getPosition() == 1)).isTrue();

    }

    @Test
    @DisplayName("자동차가 모두 멈추는 경우")
    void raceAllCars_멈춤() {
        // given
        MovingStrategy stopStrategy = new MovingStrategy(()->3);
        List<String> names = Arrays.asList("pobi", "crong", "horan");
        Cars cars = new Cars(names, stopStrategy);

        // when
        cars.raceAllCars();
        List<Car> result = cars.getCars();

        // then
        assertThat(result.stream()
                .allMatch(car -> car.getPosition() == 0)).isTrue();

    }
//
//    @Test
//    void findWinnerPosition() {
//    }
//
//    @Test
//    void findWinner() {
//    }

    private void assertArrayEquals(List<Car> expected, List<Car> result) {
    }

}