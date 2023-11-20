package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.subclass.MockCar;
import racingcar.domain.subclass.MockCars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Nested
    class SingleWinnerTests {
        @ParameterizedTest
        @CsvSource({"4,3,2,pobi", "1,2,3,jun", "2,5,4,woni"})
        void 단독_우승자인경우(int pobiDistance, int woniDistance, int junDistance, String expectedWinners) {

            List<MockCar> cars = new ArrayList<>();
            cars.add(new MockCar("pobi", pobiDistance));
            cars.add(new MockCar("woni", woniDistance));
            cars.add(new MockCar("jun", junDistance));
            MockCars raceCars =new MockCars(cars);

            List<String> answer = raceCars.determineWinner();
            List<String> expected = List.of(expectedWinners);
            assertThat(answer).isEqualTo(expected);
        }
    }

    @Nested
    class MultipleWinnersTests {
        @ParameterizedTest
        @CsvSource(value = {"4:4:4:pobi,woni,jun", "4:2:4:pobi,jun", "0:1:1:woni,jun"}, delimiter = ':')
        void 공동_우승자인경우(int pobiDistance, int woniDistance, int junDistance, String expectedWinners) {
            List<MockCar> cars = new ArrayList<>();
            cars.add(new MockCar("pobi", pobiDistance));
            cars.add(new MockCar("woni", woniDistance));
            cars.add(new MockCar("jun", junDistance));
            MockCars raceCars =new MockCars(cars);

            List<String> answer = raceCars.determineWinner();
            List<String> expected = List.of(expectedWinners.split(","));
            assertThat(answer).isEqualTo(expected);
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class getCarsTest{
        @DisplayName("getCars() 메소드 테스트")
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void getCars_메소드_테스트(List<MockCar> cars){
            MockCars raceCars = new MockCars(cars);
            Assertions.assertThat(raceCars.getCars()).isEqualTo(cars);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(List.of(new MockCar("pobi",4))),
                    Arguments.of(List.of(new MockCar("pobi",4),new MockCar("enji",3))),
                    Arguments.of(List.of(new MockCar("pobi",4),new MockCar("woni",3),new MockCar("jun",2)))
            );
        }
    }

}