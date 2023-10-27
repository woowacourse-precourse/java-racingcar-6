package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class CarsTest {

    @DisplayName("우승차를 구할때 자동차가 한대도 없는 경우 테스트 : 자동차가 한대도 없는데 우승자를 구하는 경우 IllegalArgumentException 예외발생.")
    @Test
    void validateEmpty() {
        List<Car> carList = Arrays.asList();
        Cars cars = new Cars(carList);

        assertThatThrownBy(() -> cars.findWinner())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차가 한대도 없습니다.");
    }

    @DisplayName("우승차를 구하는 테스트 : 한명 혹은 여러명의 우승자를 찾는다.")
    @Test
    void findWinner() {
        List<Car> carList = Arrays.asList(
                new Car("사람1", 3),
                new Car("사람2", 4),
                new Car("사람3", 5),
                new Car("사람4", 5)
        );
        Cars cars = new Cars(carList);

        List<Car> winner = cars.findWinner();

        assertThat(winner).usingRecursiveFieldByFieldElementComparator()
                .containsExactly(new Car("사람3", 5), new Car("사람4", 5));
    }
}