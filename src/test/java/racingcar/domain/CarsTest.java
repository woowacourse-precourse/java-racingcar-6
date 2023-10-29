package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("중복된 이름이 입력된 경우 예외 발생")
    void 예외_처리_테스트_1() {
        MovingStrategy movingStrategy = new MovingStrategy(new RandomNumberGenerator());
        List<String> names = Arrays.asList("pobi", "pobi", "crong", "horan");

        assertThrows(IllegalArgumentException.class,
                () -> {
                    new Cars(names, movingStrategy);
                });
    }
//
//    @Test
//    void getCars() {
//
//    }
//
//    @Test
//    void raceAllCars() {
//    }
//
//    @Test
//    void findWinnerPosition() {
//    }
//
//    @Test
//    void findWinner() {
//    }

}