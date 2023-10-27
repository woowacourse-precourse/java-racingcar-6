package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Iterator;
import org.junit.jupiter.api.Test;

class RaceWinnerListTest extends NsTest {

    @Test
    void 우승자_명단() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun,jiwoo");
                    assertThat(output()).contains("woni", "jiwoo");
                }, 2, 9, 3, 9
        );
    }

    @Override
    protected void runMain() {
        RaceCars raceCars = new RaceCars(Console.readLine());
        raceCars.moveForwardEach();
        RaceWinnerList winnerList = new RaceWinnerList(raceCars);
        Iterator<RaceCar> iterator = winnerList.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}