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
    void startRace() {
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