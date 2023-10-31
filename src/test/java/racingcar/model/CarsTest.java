package racingcar.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.exception.NoCarException;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

class CarsTest {
    @Test
    void 가장_먼_거리를_이동한_자동차를_기준으로_우승한_자동차들의_이름을_구할_수_있다_우승자가_하나일때() {
        Car car1 = new Car("테스트1", 2);
        Car car2 = new Car("테스트2", 3);
        Car car3 = new Car("테스트3", 4);
        Cars cars = new Cars(List.of(car1, car2, car3));

        List<String> winners = cars.getWinnerCars();
        assertThat(winners).containsOnly(car3.getName());
    }

    @Test
    void 가장_먼_거리를_이동한_자동차를_기준으로_우승한_자동차들의_이름을_구할_수_있다_우승자가_둘이상일때() {
        Car car1 = new Car("테스트1", 2);
        Car car2 = new Car("테스트2", 4);
        Car car3 = new Car("테스트3", 4);
        Cars cars = new Cars(List.of(car1, car2, car3));

        List<String> winners = cars.getWinnerCars();
        assertThat(winners).containsOnly(car2.getName(), car3.getName());
    }

    @Test
    void 자동차를_등록하지_않은_상태에서_우승자를_찾을수_없다() {
        //given
        Cars cars = new Cars(List.of());

        assertThatThrownBy(cars::getWinnerCars)
                .isInstanceOf(NoCarException.class)
                .hasMessage("등록된 자동차가 없습니다.");
    }
}