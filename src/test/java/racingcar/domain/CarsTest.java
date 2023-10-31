package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Car firstCar;
    private Car secondCar;
    private Car thirdCar;
    private Cars cars;

    @BeforeEach
    void setup() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        cars = Cars.from(carNames);

        firstCar = cars.getCars().get(0);
        secondCar = cars.getCars().get(1);
        thirdCar = cars.getCars().get(2);
    }

    @Test
    void Cars_생성자는_중복된_자동차의_이름이_들어오면_IllegalArgumentException을_발생시킨_후_애플리케이션은_종료된다() {
        List<String> cars = List.of("pobi", "woni", "pobi");

        assertThatThrownBy(() -> Cars.from(cars)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Cars의_from_메서드는_올바른_값이_주어지면_Cars_객체를_생성한다() {
        List<String> cars = List.of("pobi", "woni", "jun");

        assertThat(Cars.from(cars)).isInstanceOf(Cars.class);
    }

    @Test
    void Cars의_move_메서드는_모든_자동차가_랜덤한_숫자를_뽑아_4이상이면_위치가_증가한다() {
        NumberGenerator numberGenerator = new IncreasePositionNumber();

        cars.moveCars(numberGenerator);

        assertEquals(1, firstCar.getPosition());
        assertEquals(1, secondCar.getPosition());
        assertEquals(1, thirdCar.getPosition());
    }

    @Test
    void Cars의_move_메서드는_모든_자동차가_랜덤한_숫자를_뽑아_4보다_작으면_위치가_증가하지_않는다() {
        NumberGenerator numberGenerator = new NotIncreasePositionNumber();

        cars.moveCars(numberGenerator);

        assertEquals(0, firstCar.getPosition());
        assertEquals(0, secondCar.getPosition());
        assertEquals(0, thirdCar.getPosition());
    }

    @Test
    void 각_자동차의_최대_위치를_계산해서_리스트에_넣고_리스트에_포함되어_있으면_true를_반환한다() {
        firstCar.movePosition(4);
        secondCar.movePosition(5);
        thirdCar.movePosition(2);

        List<String> winners = cars.getWinners();

        assertTrue(winners.contains("pobi"));
        assertTrue(winners.contains("woni"));
        assertFalse(winners.contains("jun"));
    }
}
