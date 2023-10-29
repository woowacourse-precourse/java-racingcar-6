package racingcar.domain.game;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class RoundTest {
    @DisplayName("라운드가 끝나면 자동차는 전진 또는 정지 상태여야 한다.")
    @Test
    void 라운드별_자동차_경주_기능_테스트() {
        //given
        List<Integer> numbers = List.of(5,1,9);
        String names = "jun,pobi,woni";
        Cars cars = new Cars(names);
        Round round = new Round(numbers, cars);

        //when
        round.race();

        //then
        List<Car> afterRoundCars = cars.getCars();
        assertThat(afterRoundCars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()))
                .isEqualTo(List.of(1,0,1));
    }
}
