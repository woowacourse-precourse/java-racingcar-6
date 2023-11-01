package racingcar.domain;

import org.junit.jupiter.api.*;
import racingcar.utils.RandomGenerator;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Nested
    class Situation1 {
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
            for (int i = 0; i < raceRound; i++) {
                cars.move();
            }
            Assertions.assertEquals(Arrays.asList("ABC", "DEF"), cars.getWinnersName());
        }
    }

    @Nested
    class Situation2 {
        Car immovableCar1;
        Car immovableCar2;
        Car immovableCar3;
        int raceRound = 5;
        Cars immovablecars;

        @BeforeEach
        void setUp() {
            immovableCar1 = new Car("ABC", () -> 3);
            immovableCar2 = new Car("DEF", () -> 3);
            immovableCar3 = new Car("GHI", () -> 3);
            immovablecars = new Cars(Arrays.asList(immovableCar1, immovableCar2, immovableCar3));
        }

        @Test
        @DisplayName("아무도 움직이지  않으면 우승자 없음")
        void 우승자_없음_테스트() {
            for (int i = 0; i < raceRound; i++) {
                immovablecars.move();
            }
            Assertions.assertTrue(immovablecars.getWinnersName().isEmpty());
        }
    }

}