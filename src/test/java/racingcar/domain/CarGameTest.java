package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDTO;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @DisplayName("CarGame race 테스트")
    @Test
    void carGameRaceTest() {

        // given
        List<String> names = List.of("a", "b", "c");
        int carSize = names.size();
        int gameSize = 10;
        List<CarName> carNames = names.stream()
                .map(CarName::new)
                .toList();
        Cars cars = Cars.createByNames(carNames);
        CarGameRound carGameRound = CarGameRound.createByString(Integer.toString(gameSize));
        CarGame carGame = CarGame.create(cars, carGameRound);

        // when
        CarDTO.ProgressResult status = carGame.race();
        List<Map<String, Integer>> result = status.getResult();

        // then
        assertThat(status).isInstanceOf(CarDTO.ProgressResult.class);
        assertThat(result.size()).isEqualTo(gameSize);
        for (Map<String, Integer> roundStatus : result) {
            Set<String> keys = roundStatus.keySet();
            assertThat(keys.size()).isEqualTo(carSize);
            assertThat(keys.containsAll(names)).isTrue();
        }
    }

    @DisplayName("CarGame getWinner 테스트")
    @Test
    void carGameGetWinnerTest() {

        // given
        List<String> names = List.of("a", "b", "c");
        int gameSize = 10;
        List<CarName> carNames = names.stream()
                .map(CarName::new)
                .toList();
        Cars cars = Cars.createByNames(carNames);
        CarGameRound carGameRound = CarGameRound.createByString(Integer.toString(gameSize));
        CarGame carGame = CarGame.create(cars, carGameRound);

        // when
        CarDTO.WinnerNames winnerNames = carGame.getWinner();

        // then
        assertThat(winnerNames).isInstanceOf(CarDTO.WinnerNames.class);
        assertThat(names.containsAll(winnerNames.getNames())).isTrue();
    }
}