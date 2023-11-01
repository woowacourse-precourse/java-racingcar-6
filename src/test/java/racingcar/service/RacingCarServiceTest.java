package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.util.GlobalExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarServiceTest {

    final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    @Test
    void 참가하는_자동차_이름_문자열_받아와_리스트로_변환() {
        final String cars = "one,two,three,four";
        List<String> carArray = new ArrayList<>();

        if (globalExceptionHandler.isValidCarArray(cars)){
            carArray = List.of(cars.split(","));
        }

        assertThat(carArray).containsExactly("one", "two", "three", "four");
    }

    @Test
    void 자동차_경주_객체_생성하기() {
        final String racingCount = "4";
        Car one = new Car("one");
        Car two = new Car("two");
        Car three = new Car("three");
        Car four = new Car("four");
        List<Car> racingCarList = new ArrayList<Car>(Arrays.asList(one, two, three, four));
        Racing racingGame = null;

        if (globalExceptionHandler.isValidRacingCount(racingCount)) {
            racingGame = new Racing(racingCarList, Integer.parseInt(racingCount));
        }

        Racing result = new Racing(Arrays.asList(one, two, three, four), 4);
        assertThat(racingGame).usingRecursiveComparison().isEqualTo(result);
    }

    @Test
    void countAhead() {
    }

    @Test
    void startRacingRound() {
    }

    @Test
    void getAheadCountList() {
    }

    @Test
    void updateWinnerList() {
    }
}