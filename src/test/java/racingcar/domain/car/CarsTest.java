package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.domain.car.NameConstants.NAME_DUPLICATED;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {
    private final Rule rule = new DecideRule();
    private final Generator generator = new RandomNumberGenerator();
    private final Decider decider = Decider.of(rule, generator);
    @Test
    void 중복_이름을_입력할_경우_예외_반환() {
        Car car1 = Car.withName(new Name("first"));
        Car car2 = Car.withName(new Name("first"));

        assertThatThrownBy(() -> Cars.of(List.of(car1, car2), decider))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_DUPLICATED);
    }

    @Test
    void 단독_우승일_경우_우승자가_하나다() {
        //given
        Car one = Car.withName(new Name("one"));
        one.go();
        Car two = Car.withName(new Name("two"));
        two.go();
        two.go();
        Car three = Car.withName(new Name("three"));
        three.go();
        three.go();
        three.go();
        Cars cars = Cars.of(List.of(one, two, three), decider);

        //when
        List<Car> winners = cars.findWinner();

        //then
        assertEquals(1, winners.size());
        assertTrue(winners.contains(three));
    }
    @Test
    void 공동_우승일_경우_우승자가_여러_명이다() {
        //given
        Car one = Car.withName(new Name("one"));
        one.go();
        Car two = Car.withName(new Name("two"));
        two.go();
        two.go();
        Car anotherTwo = Car.withName(new Name("Two"));
        anotherTwo.go();
        anotherTwo.go();
        Cars cars = Cars.of(List.of(one, two, anotherTwo), decider);

        //when
        List<Car> winners = cars.findWinner();

        //then
        assertEquals(2, winners.size());
        assertTrue(winners.contains(two));
        assertTrue(winners.contains(anotherTwo));
    }
}