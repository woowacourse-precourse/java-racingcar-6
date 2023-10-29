package racingcar.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class MoveOrStopCarTest {
    private final MoveOrStopCar moveOrStopCar = new MoveOrStopCar();

    @DisplayName("주어진 횟수 동안 무작위값이 4이상일경우 자동차는 전진한다.")
    @Test
    void 무작위값이_4이상일경우_자동차는_전진한다() {
        //given
        Integer numberOfTimes = 3;
        List<Car> cars = Arrays.asList(
                new Car("kim", 0)
                ,new Car("bi",0));

        //when
        moveOrStopCar.setRamdomStartNumber(4);
        moveOrStopCar.setRamdomEndNumber(5);
        moveOrStopCar.moveOrStopCarsForGivenTimes(numberOfTimes, cars);


        //then
        List<Integer> moveNumbers = cars.stream().map(Car::getMoveNumber).collect(Collectors.toList());
        for (Integer moveNumber : moveNumbers) {
           assertThat(moveNumber).isEqualTo(3);
        }

    }

    @DisplayName("주어진 횟수 동안 무작위값이 4이하일경우 자동차는 정지한다.")
    @Test
    void 무작위값이_4이하일경우_자동차는_정지한다() {
        //given
        Integer numberOfTimes = 3;
        List<Car> cars = Arrays.asList(
                new Car("kim", 0)
                ,new Car("bi",0));

        //when
        moveOrStopCar.setRamdomStartNumber(1);
        moveOrStopCar.setRamdomEndNumber(3);
        moveOrStopCar.moveOrStopCarsForGivenTimes(numberOfTimes, cars);


        //then
        List<Integer> moveNumbers = cars.stream().map(Car::getMoveNumber).collect(Collectors.toList());
        for (Integer moveNumber : moveNumbers) {
            assertThat(moveNumber).isEqualTo(0);
        }

    }
}