package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.mock.MockNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {

    @DisplayName("Cars 생성 성공 테스트")
    @Test
    void createCarsSuccessTest() {

        // given
        List<CarName> carNames = Stream.of("a", "b", "c").map(CarName::new).toList();

        // when
        Cars cars = Cars.createByNames(carNames);

        // then
        assertThat(cars).isNotNull();
    }

    @DisplayName("Cars 생성 실패 테스트 - 중복")
    @Test
    void createCarsFailTest_1() {

        // given
        List<CarName> carNames = Stream.of("a", "a", "c").map(CarName::new).toList();

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> Cars.createByNames(carNames));
    }

    @DisplayName("Cars 생성 실패 테스트 - 공백")
    @Test
    void createCarsFailTest_2() {

        // given
        List<CarName> carNames = new ArrayList<>();

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> Cars.createByNames(carNames));
    }

    private List<Integer> getExpectedNumbers(int nameSize, int gameSize) {
        List<Integer> expectedNumbers = new ArrayList<>();
        for (int i = 0; i < nameSize * gameSize; i++) {
            expectedNumbers.add(i % 10);
        }
        return expectedNumbers;
    }

    @DisplayName("Cars goForward 테스트")
    @Test
    void carsGoForwardTest() {

        // given
        List<String> names = List.of("a", "b", "c");
        List<CarName> carNames = names.stream().map(CarName::new).toList();

        int gameSize = 1;

        Cars cars = Cars.createByNames(carNames);
        List<Integer> expectedNumbers = getExpectedNumbers(names.size(), gameSize);
        MockNumberGenerator mockNumberGenerator = new MockNumberGenerator(expectedNumbers);
        cars.moveAll(mockNumberGenerator);
        List<Integer> expectedStatusValues = new ArrayList<>();
        for (Integer expectedNumber : expectedNumbers) {
            if (expectedNumber >= 4) {
                expectedStatusValues.add(1);
                continue;
            }
            expectedStatusValues.add(0);
        }


        // when
        Map<String, Integer> status = cars.getStatus();
        List<Integer> values = List.of(status.values().toArray(new Integer[0]));
        // then
        for (int i = 0; i < values.size(); i++) {
            assertThat(values.get(i)).isEqualTo(expectedStatusValues.get(i));
        }
    }

    @DisplayName("Cars getWinningCarNames 테스트")
    @Test
    void carsGetWinningCarNamesTest() {

        // given
        List<String> names = List.of("a", "b", "c");
        List<CarName> carNames = names.stream().map(CarName::new).toList();

        Cars cars = Cars.createByNames(carNames);

        cars.moveAll(() -> Randoms.pickNumberInRange(0, 9));

        // when
        List<String> winningCarNames = cars.findWinningCarNames();

        // then
        assertThat(names.containsAll(winningCarNames)).isTrue();
    }
}