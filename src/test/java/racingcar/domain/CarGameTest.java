package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarGameTest {

    @DisplayName("CarGame 생성 테스트")
    @Test
    void createCarGame() {

        // given
        List<String> names = List.of("a", "b", "c");
        List<CarName> carNames = names.stream()
                .map(CarName::new)
                .toList();
        Cars cars = Cars.createByNames(carNames);
        CarGameRound carGameRound = CarGameRound.createByString("10");

        // when
        CarGame carGame = CarGame.create(cars, carGameRound);

        // then
        assertThat(carGame).isNotNull();
    }
}