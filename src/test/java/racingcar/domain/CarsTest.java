package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.CarFactory;

public class CarsTest {
    @DisplayName("자동차 개수가 1대 이하 시 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"poby"})
    void failCarSizeSmallTest(String name) {
        List<String> carNames = new ArrayList<>();
        carNames.add(name);

        Assertions.assertThatThrownBy(() -> CarFactory.generate(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 개수가 10대 초과 시 예외를 발생시킨다.")
    @Test
    void failCarSizeOverTest() {
        List<String> carNames = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            carNames.add(Integer.toString(i));
        }

        Assertions.assertThatThrownBy(() -> CarFactory.generate(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 자동차 이름은 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"poby"})
    void failCarNameDuplicateTest(String duplicateName) {
        List<String> carNames = new ArrayList<>();
        carNames.add(duplicateName);
        carNames.add(duplicateName);

        Assertions.assertThatThrownBy(() -> CarFactory.generate(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("getWinnerCars()는 가장 큰 position을 가진 모든 차들을 가져온다.")
    @Test
    void getWinnersCars() {
        Cars cars = createCars();
        cars.move();
        List<Car> winnerCars = cars.getWinnerCars();

        int maxPosition = winnerCars.get(0).getPosition();
        int maxPositionCarCount = (int) cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .count();

        Assertions.assertThat(winnerCars.size()).isEqualTo(maxPositionCarCount);
    }

    private Cars createCars() {
        List<String> carNames = new ArrayList<>();
        String carNamePrefix = "abcde";
        for (int i = 0; i < 5; i++) {
            carNames.add("car" + carNamePrefix.charAt(i));
        }

        return CarFactory.generate(carNames);
    }
}
