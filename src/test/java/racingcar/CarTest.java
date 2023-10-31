package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

class CarTest {

    private static final int moving = 4;
    private static final int stop = 3;

    @Test
    void runRace_메소드에서_자동차가_0부터_9까지_수에서_4이상이_나올_경우_전진() {
        String[] input = {"test1"};
        Car testRacing = new Car(input);

        assertRandomNumberInRangeTest(
                () -> {
                    testRacing.runRace(2);
                    int result = testRacing.getCarPosition("test1");
                    assertThat(result).isEqualTo(1);
                },
                stop, moving
        );
    }

    @Test
    void makeWinnerList_메소드를_실행_했을_때_우승자_명단_작성() {
        String[] input = {"test1", "test2"};
        Car testRacing = new Car(input);

        assertRandomNumberInRangeTest(
                () -> {
                    testRacing.runRace(1);
                    ArrayList<String> result = testRacing.makeWinnerList();
                    assertThat(result).contains("test2");
                },
                moving, stop
        );
    }

    @Test
    void makeWinnerList_메소드를_실행_했을_때_공동_우승() {
        String[] input = {"test1", "test2"};
        Car testRacing = new Car(input);

        assertRandomNumberInRangeTest(
                () -> {
                    testRacing.runRace(1);
                    ArrayList<String> result = testRacing.makeWinnerList();
                    assertThat(result).contains("test1", "test2");
                },
                moving, moving
        );
    }
}