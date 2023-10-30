package racingcar.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.Numbers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarRaceTest {

    List<Car> cars = Arrays.asList(
            new Car("pobi", ""),
            new Car("woni", ""),
            new Car("jun", "")
    );

    @Test
    @DisplayName("숫자가 4이상일 때 자동차가 전진하는지 테스트")
    public void moveForwardTest(){

        CarRace carRace = new CarRace(cars);

        List<String> originalPosition = cars.stream()
                .map(car -> car.getPosition())
                .collect(Collectors.toList());

        int randomNumber = Randoms.pickNumberInRange(
                Numbers.MOVE_POSITION_NUMBER.getNumber(),
                Numbers.RANDOM_END_NUMBER.getNumber()
        );
        carRace.moveForward(randomNumber);

        List<String> movedPosition = cars.stream()
                .map(car -> car.getPosition())
                .collect(Collectors.toList());

        assertThat(originalPosition).isNotEqualTo(movedPosition);
    }



}