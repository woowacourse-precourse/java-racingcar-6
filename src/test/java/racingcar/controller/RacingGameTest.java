package racingcar.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
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
    void moveCarOrNotTest(int i, int index, int expected) {
        //carService.moveCarorNot의 두번째 인자값이 NumberConstant.Target_Number 보다 크면 첫번째 인자값에 위치한 자동차의 위치를 증가시켜야함
        racingGame.moveCarOrNot(index, NumberConstant.TARGET_NUMBER + i);
        assertThat(cars.getCarNamePositionMap().get(carArray[index])).isEqualTo(expected);
    }

    @Test
    @DisplayName("우승 자동차 이름 확인 테스트")
    void getVictoryCarNameTest() {
        cars.moveCar(0);
        cars.moveCar(1);
        List<String> resultCarlist = new ArrayList<>(Arrays.asList("벤츠", "아우디"));
        Assertions.assertThat(racingGame.getVictoryCarNames()).isEqualTo(resultCarlist);
    }
}