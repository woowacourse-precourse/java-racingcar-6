package racingcar;

import org.junit.jupiter.api.Test;
import pojo.RacingCar;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrintWinnerTest {

    RacingCar[] racingCars = {new RacingCar("우아한",8),new RacingCar("테크",2),new RacingCar("코스",6)};

    @Test
    void testWinnerNum_자동차_그룹_중_가장_멀리간_거리_반환() {

        PrintWinner printWinner = new PrintWinner(racingCars);
        int result = printWinner.winnerNum();

        assertEquals(8, result);
    }

    @Test
    void testWinnerList_자동차_그룹_중_가장_멀리간_자동차_객체_리스트_반환() {

        PrintWinner printWinner = new PrintWinner(racingCars);
        List<String> result = printWinner.winnerList();
        List<String> expected = Arrays.asList("우아한");

        assertEquals(expected, result);
    }


}