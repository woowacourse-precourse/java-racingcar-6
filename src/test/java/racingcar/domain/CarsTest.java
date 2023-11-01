package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.CarFactory;

public class CarsTest {

    @Test
    @DisplayName("자동차 개수가 2대 미만이면 예외를 발생시킨다.")
    void carSizeOneTest() {
        List<String> carNames = new ArrayList<>();
        carNames.add(Integer.toString(0));

        Assertions.assertThatThrownBy(() -> CarFactory.generate(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 개수가 10대보다 많으면 예외를 발생시킨다.")
    void carSizeOverTest() {
        List<String> carNames = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            carNames.add(Integer.toString(i));
        }

        Assertions.assertThatThrownBy(() -> CarFactory.generate(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 자동차 이름은 예외를 발생시킨다.")
    void carNameDuplicateTest() {
        List<String> carNames = new ArrayList<>();
        String duplicateName = Integer.toString(0);
        carNames.add(duplicateName);
        carNames.add(duplicateName);

        Assertions.assertThatThrownBy(() -> CarFactory.generate(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("가장 큰 position을 가진 차들은 모두 우승자여야 한다.")
    void winnerPositionTest() {
        List<String> carNames = new ArrayList<>();
        String carNamePrefix = "abcde";
        for (int i = 0; i < 5; i++) {
            carNames.add("car" + carNamePrefix.charAt(i));
        }

        Cars cars = CarFactory.generate(carNames);
        for (int i = 0; i < 5; i++) {
            cars.move();
        }

        List<Car> winnerCars = cars.getWinnerCars();
        int maxPosition = winnerCars.get(0).getPosition();
        int maxPositionCarCount = (int) cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .count();

        Assertions.assertThat(winnerCars.size()).isEqualTo(maxPositionCarCount);
    }
}
