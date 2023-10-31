package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.presentation.CarDTO;
import racingcar.util.mock.MockNumberGenerator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        int gameSize = 3;
        CarGame carGame = generateCarGame(names, gameSize);
        List<Integer> expectedNumbers = getExpectedNumbers(names, gameSize);
        List<Map<String, Integer>> expectedStatus = getExpectedStatus(names, gameSize, expectedNumbers);
        CarDTO.ProgressResult expectedProgressResult = new CarDTO.ProgressResult(expectedStatus);

        MockNumberGenerator mockNumberGenerator = new MockNumberGenerator(expectedNumbers);

        // when
        CarDTO.ProgressResult status = carGame.race(mockNumberGenerator);

        // then
        assertThat(status).usingRecursiveComparison().isEqualTo(expectedProgressResult);
    }

    private List<Map<String, Integer>> getExpectedStatus(List<String> names, int gameSize, List<Integer> expectedNumbers) {
        List<Map<String, Integer>> expectedStatus = new ArrayList<>();
        List<Integer> prevPosition = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            prevPosition.add(0);
        }

        for (int i = 0; i < gameSize; i++) {
            Map<String, Integer> roundStatus = new LinkedHashMap<>();

            for (int j = 0; j < names.size(); j++) {
                Integer expectNumber = expectedNumbers.get(i * names.size() + j);
                Integer prevNumber = prevPosition.get(j);
                if (expectNumber >= 4) {
                    prevPosition.set(j, prevNumber + 1);
                    roundStatus.put(names.get(j), prevNumber + 1);
                    continue;
                }
                roundStatus.put(names.get(j), prevNumber);
            }
            expectedStatus.add(roundStatus);
        }
        return expectedStatus;
    }

    private List<Integer> getExpectedNumbers(List<String> names, int gameSize) {
        List<Integer> expectedNumbers = new ArrayList<>();
        for (int i = 0; i < names.size() * gameSize; i++) {
            expectedNumbers.add(Randoms.pickNumberInRange(0, 9));
        }
        return expectedNumbers;
    }

    private CarGame generateCarGame(List<String> names, int gameSize) {
        List<CarName> carNames = names.stream()
                .map(CarName::new)
                .toList();
        Cars cars = Cars.createByNames(carNames);
        CarGameRound carGameRound = CarGameRound.createByString(Integer.toString(gameSize));
        return CarGame.create(cars, carGameRound);
    }

    @DisplayName("CarGame getWinner 테스트")
    @Test
    void carGameGetWinnerTest() {

        // given
        List<String> names = List.of("a", "b", "c");
        int gameSize = 10;
        CarGame carGame = generateCarGame(names, gameSize);

        // when
        CarDTO.WinnerNames winnerNames = carGame.getWinner();

        // then
        assertThat(names).usingRecursiveComparison().isEqualTo(winnerNames.getNames());
    }
}