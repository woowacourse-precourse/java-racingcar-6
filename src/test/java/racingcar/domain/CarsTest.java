package racingcar.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.controller.dto.Result;
import racingcar.policy.RacingCarGameMovingPolicy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {

    @Test
    void 모든_자동차_순서가_같다면_자동차들의_동등성을_보장한다() {
        // given, when
        Car car1 = new Car(new CarName("자동차1"), new Position(0));
        Car car2 = new Car(new CarName("자동차2"), new Position(1));
        Cars cars1 = new Cars(List.of(car1, car2));

        Car car3 = new Car(new CarName("자동차1"), new Position(0));
        Car car4 = new Car(new CarName("자동차2"), new Position(1));
        Cars cars2 = new Cars(List.of(car3, car4));

        // then
        assertAll(
                () -> assertThat(cars1).isEqualTo(cars2),
                () -> assertThat(cars1).hasSameHashCodeAs(cars2)
        );
    }

    @Test
    void 모든_자동차_순서가_같지_않으면_자동차들의_동등성을_보장하지_않는다() {
        // given, when
        Car car1 = new Car(new CarName("자동차1"), new Position(0));
        Car car2 = new Car(new CarName("자동차2"), new Position(1));
        Cars cars1 = new Cars(List.of(car1, car2));

        Car car3 = new Car(new CarName("자동차2"), new Position(1));
        Car car4 = new Car(new CarName("자동차1"), new Position(0));
        Cars cars2 = new Cars(List.of(car3, car4));

        // then
        assertAll(
                () -> assertThat(cars1).isNotEqualTo(cars2),
                () -> assertThat(cars1).doesNotHaveSameHashCodeAs(cars2)
        );
    }


    @Test
    void 자동차들을_룰에_따라_게임을_진행하는데_성공한다() {
        Rule rule = new Rule(new RacingCarGameMovingPolicy(), () -> 9);
        // given
        Car beforeGameCar1 = new Car(new CarName("자동차1"), new Position(1));
        Car beforeGameCar2 = new Car(new CarName("자동차2"), new Position(3));
        Car beforeGameCar3 = new Car(new CarName("자동차3"), new Position(5));
        Cars carsBeforeGame = new Cars(List.of(beforeGameCar1, beforeGameCar2, beforeGameCar3));

        Car afterGameCar1 = new Car(new CarName("자동차1"), new Position(2));
        Car afterGameCar2 = new Car(new CarName("자동차2"), new Position(4));
        Car afterGameCar3 = new Car(new CarName("자동차3"), new Position(6));
        Cars carsExpected = new Cars(List.of(afterGameCar1, afterGameCar2, afterGameCar3));

        // when
        Cars carsAfterGame = carsBeforeGame.playGame(rule);

        //then
        assertThat(carsAfterGame).isEqualTo(carsExpected);
    }

    @Test
    void 자동차를_결과_리스트로_변경에_성공한다() {
        // given
        Car car1 = new Car(new CarName("자동차1"), new Position(1));
        Car car2 = new Car(new CarName("자동차2"), new Position(3));
        Car car3 = new Car(new CarName("자동차3"), new Position(5));
        Cars cars = new Cars(List.of(car1, car2, car3));
        List<Result> expectedResults = List.of(
                new Result("자동차1", 1),
                new Result("자동차2", 3),
                new Result("자동차3", 5)
        );

        // when
        List<Result> results = cars.getResults();

        // then
        assertThat(results).isEqualTo(expectedResults);
    }


    @Test
    void 자동차들_중_우승자를_계산하는데_성공한다() {
        // given
        Car car1 = new Car(new CarName("자동차1"), new Position(1));
        Car car2 = new Car(new CarName("자동차2"), new Position(5));
        Car car3 = new Car(new CarName("자동차3"), new Position(10));
        Cars cars = new Cars(List.of(car1, car2, car3));
        Result winner = new Result("자동차3", 10);

        // when
        List<Result> results = cars.calculateWinners();

        // then
        assertThat(results).containsExactly(winner);

    }

    @Test
    void 자동차들_중_중복_우승자를_계산하는데_성공한다() {
        // given
        Car car1 = new Car(new CarName("자동차1"), new Position(10));
        Car car2 = new Car(new CarName("자동차2"), new Position(10));
        Car car3 = new Car(new CarName("자동차3"), new Position(10));
        Cars cars = new Cars(List.of(car1, car2, car3));
        Result winner1 = new Result("자동차1", 10);
        Result winner2 = new Result("자동차2", 10);
        Result winner3 = new Result("자동차3", 10);

        // when
        List<Result> results = cars.calculateWinners();

        // then
        assertThat(results).containsExactly(winner1, winner2, winner3);
    }

}
