package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.RandomGenerator;

import java.util.Arrays;
import java.util.List;


class CarsTest {

    Car movableCar1;
    Car movableCar2;
    Car immovableCar;
    int raceRound = 5;
    Cars cars;

    @BeforeEach
    void setUp() {
        movableCar1 = new Car("ABC", () -> 4);
        movableCar2 = new Car("DEF", () -> 4);
        immovableCar = new Car("GHI", () -> 3);
        cars = new Cars(Arrays.asList(movableCar1, movableCar2, immovableCar));
    }

    @Test
    @DisplayName("차들의 position을 얻으면 (5,5,0)과 같다")
    void move테스트() {

        for (int i = 0; i < raceRound; i++) {
            cars.move();
        }
        List<Integer> positions = cars.getCars().stream()
                .map(Car::getPosition)
                .toList();

        Assertions.assertEquals(Arrays.asList(5, 5, 0), positions);
    }

    @Test
    @DisplayName("새로운 Car객체 추가 및 삭제 불가")
    void getCars테스트() {
        Assertions.assertThrows(UnsupportedOperationException.class,
                () -> {
                    cars.getCars().add(new Car("ADD", new RandomGenerator()));
                });

        Assertions.assertThrows(UnsupportedOperationException.class,
                () -> {
                    cars.getCars().clear();
                });
    }

    @Test
    void 우승자_판별_테스트() {
        Cars cars = new Cars(Arrays.asList(movableCar1, movableCar2, immovableCar));
        for (int i = 0; i < raceRound; i++) {
            cars.move();
        }
        Assertions.assertEquals(Arrays.asList("ABC", "DEF"), cars.getWinnerNameList());
    }

}