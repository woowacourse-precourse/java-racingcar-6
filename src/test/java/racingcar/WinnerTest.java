package racingcar;

import net.bytebuddy.implementation.InvokeDynamic;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnerTest {

    @Test
    void 단독_승자_확인() {
        //given
        RacingCar test1 = new RacingCar("test1", 4);
        RacingCar test2 = new RacingCar("test2", 3);
        RacingCar test3 = new RacingCar("test3", 2);
        List<RacingCar> testRacingCars = new ArrayList<RacingCar>(Arrays.asList(test1, test2, test3));

        //when
        Winner testWinner = Winner.createWinner(testRacingCars);

        //then
        assertThat(testWinner).usingRecursiveComparison().isEqualTo(new Winner(Arrays.asList("test1"),WinnerType.SINGLE));
    }

    @Test
    void 공동_승자_확인() {
        //given
        RacingCar test1 = new RacingCar("test1", 4);
        RacingCar test2 = new RacingCar("test2", 4);
        RacingCar test3 = new RacingCar("test3", 2);
        List<RacingCar> testRacingCars = new ArrayList<RacingCar>(Arrays.asList(test1, test2, test3));

        //when
        Winner testWinner = Winner.createWinner(testRacingCars);

        //then
        assertThat(testWinner).usingRecursiveComparison().isEqualTo(new Winner(Arrays.asList("test1","test2"),WinnerType.JOINT));
    }
}
