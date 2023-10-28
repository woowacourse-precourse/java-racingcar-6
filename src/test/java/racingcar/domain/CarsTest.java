package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void Cars의_from_메서드는_올바른_값이_주어지면_Cars_객체를_생성한다() {
        List<String> cars = List.of("pobi", "woni", "jun");

        assertThat(Cars.from(cars)).isInstanceOf(Cars.class);
    }

    @Test
    void Cars의_move_메서드는_모든_자동차가_랜덤한_숫자를_뽑아_4이상이면_위치가_증가한다() {
        NumberGenerator numberGenerator = new IncreasePositionNumber();

        Car firstCar = new Car("pobi");
        Car secondCar = new Car("woni");

        Cars cars = new Cars(List.of(firstCar, secondCar));

        cars.move(numberGenerator);

        assertEquals(1, firstCar.getPosition());
        assertEquals(1, secondCar.getPosition());
    }

    @Test
    void Cars의_move_메서드는_모든_자동차가_랜덤한_숫자를_뽑아_4보다_작으면_위치가_증가하지_않는다() {
        NumberGenerator numberGenerator = new NotIncreasePositionNumber();

        Car firstCar = new Car("pobi");
        Car secondCar = new Car("woni");

        Cars cars = new Cars(List.of(firstCar, secondCar));

        cars.move(numberGenerator);

        assertEquals(0, firstCar.getPosition());
        assertEquals(0, secondCar.getPosition());
    }
}
