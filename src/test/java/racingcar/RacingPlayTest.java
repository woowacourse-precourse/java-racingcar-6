package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.RacingController;
import racingcar.domain.Car;
import racingcar.domain.ForwardTryCount;
import racingcar.domain.RacingCars;
import racingcar.vo.CarName;

public class RacingPlayTest {



    @DisplayName("전진 횟수만큼 게임이 진행되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "5"})
    void ForwardTryCountTest(String input) {
        ForwardTryCount count = new ForwardTryCount(input);
        int timeMeter = 0;

        while (!count.hasZeroCount()) {
            count.subCount();
            timeMeter++;
        }

        Assertions.assertThat(Integer.parseInt(input)).isSameAs(timeMeter);

    }

    @DisplayName("자동차의 전진횟수와 이름에 맞게 라운드 진행 결과가 생성되는지 테스트")
    @Test
    void roundResultTest() {
        Car car = new Car(new CarName("pobi"));
        car.moveForward();
        car.moveForward();
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        RacingCars racingCars = new RacingCars(cars);

        String expectedResult = "pobi : --\n";
        Assertions.assertThat(racingCars.showCarsStates()).isEqualTo(expectedResult);
    }








}

