package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.constant.NumberConstant;
import racingcar.model.Cars;
import racingcar.model.TryCount;

class RacingGameTest {

    private final String[] carArray = {"벤츠", "아우디", "BMW", "페라리"};
    private Cars cars;
    private RacingGame racingGame;

    @BeforeEach
    void beforeEach() {
        cars = new Cars(carArray);
        racingGame = new RacingGame(cars, new TryCount("1"));
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0,1", "-1,0,0"})
    @DisplayName("랜덤값에 따른 자동차 위치 증가 테스트")
    void moveCarOrNotTest(int i, int index, int expectedPosition) {
        //given
        racingGame.moveCarOrNot(index, NumberConstant.TARGET_NUMBER + i);

        //when
        int carPositionAtIndex = cars.getCarNamePositionMap().get(carArray[index]);

        //then
        assertThat(carPositionAtIndex).isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("우승 자동차 이름 확인 테스트")
    void getVictoryCarNameTest() {
        //given
        cars.moveCar(0);
        cars.moveCar(1);
        List<String> expectedCarNames = new ArrayList<>(Arrays.asList("벤츠", "아우디"));

        //when
        List<String> victoryCarNames = racingGame.getVictoryCarNames();

        //then
        assertThat(victoryCarNames).isEqualTo(expectedCarNames);
    }
}