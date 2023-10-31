package racingcar.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.game.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameSettingTest {

    private GameSetting setting;

    @BeforeEach
    void beforeEach() {
        setting = new GameSetting();
    }

    @AfterEach
    void afterEach() {
        setting = null;
    }

    @Test
    void 자동차_및_이동_횟수_최초_세팅() {
        initializeSettingCars("hwang", "jung", "seop");
        initializeSettingRound(5);

        assertThat(setting.getCars())
                .extracting("name")
                .containsExactly("hwang", "jung", "seop");
        assertThat(setting.getRound()).isEqualTo(5);
    }

    @Test
    void 이름이_6자_이상이면_예외() {
        assertThatThrownBy(() -> initializeSettingCars("hwang", "jung", "seoppp"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름이 1~5자 사이가 아닙니다.");
    }

    @Test
    void 각_자동차_1회_전진_시도_후_상태_체크() {
        initializeSettingCars("hwang", "jung", "seop", "abcde");

        setting.tryCarsForward();
        List<Car> cars = setting.getCars();
        List<String> carStates = new ArrayList<>();
        for (Car car : cars) {
            carStates.add(car.getCarState());
        }

        assertThat(setting.getCarsState()).isEqualTo(carStates);
    }

    private void initializeSettingCars(String... cars) {
        List<String> carNameList = Arrays.asList(cars);
        setting.initializeCars(carNameList);
    }

    private void initializeSettingRound(int round) {
        setting.initializeRound(round);
    }

}