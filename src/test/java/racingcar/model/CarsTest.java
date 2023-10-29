package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;
import java.util.Arrays;
import java.util.List;

class CarsTest {

    static Cars createCars() {
        List<Car> carList = Arrays.asList(
                new Car("사람1", 3),
                new Car("사람2", 4),
                new Car("사람3", 5),
                new Car("사람4", 5)
        );
        return new Cars(carList);
    }

    @DisplayName("toDtos() 테스트 : 모든 Car들을 CarDto 리스트로 변환한다.")
    @Test
    void toDtos() {
        Cars cars = createCars();

        List<CarDto> carDtos = cars.toDtos();

        assertThat(carDtos).usingRecursiveFieldByFieldElementComparator()
                .containsExactly(
                        new CarDto("사람1", 3),
                        new CarDto("사람2", 4),
                        new CarDto("사람3", 5),
                        new CarDto("사람4", 5)
                );
    }

    @DisplayName("우승자를 구할때 자동차가 한대도 없는 경우 예외 테스트 : 자동차가 한대도 없는데 우승자를 구하는 경우 IllegalArgumentException가 발생한다.")
    @Test
    void 예외발생_자동차가_없는데_우승자를_구하는경우() {
        List<Car> carList = Arrays.asList();
        Cars cars = new Cars(carList);

        assertThatThrownBy(() -> cars.findWinner())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 자동차가 한대도 없습니다.");
    }

    @DisplayName("findWinner() 테스트 : 한명 혹은 여러명의 우승자를 찾는다.")
    @Test
    void findWinner() {
        Cars cars = createCars();

        List<Car> winner = cars.findWinner();

        assertThat(winner).usingRecursiveFieldByFieldElementComparator()
                .containsExactly(new Car("사람3", 5), new Car("사람4", 5));
    }
}