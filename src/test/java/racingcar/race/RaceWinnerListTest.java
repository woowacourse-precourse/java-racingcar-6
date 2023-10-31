package racingcar.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.view.NamesInput;

class RaceWinnerListTest {

    private static MockedStatic<Randoms> random;
    private static MockedStatic<Console> console;

    @BeforeAll
    public static void beforeAll() {
        random = mockStatic(Randoms.class);
        console = mockStatic(Console.class);
    }

    @AfterAll
    public static void afterAll() {
        random.close();
        console.close();
    }

    @Test
    void 우승자_명단() {
        // given
        random.when(() -> Randoms.pickNumberInRange(0, 9))
                .thenReturn(2).thenReturn(9).thenReturn(3).thenReturn(9);
        console.when(Console::readLine).thenReturn("pobi,woni,jun,jiwoo");
        Iterator<String> answerIterator = List.of("woni", "jiwoo").iterator();

        // when
        RaceCars raceCars = new RaceCars(new NamesInput());
        raceCars.moveForwardEach();

        // then
        RaceWinnerList winnerList = new RaceWinnerList(raceCars);
        Iterator<RaceCar> winnerIterator = winnerList.getIterator();

        while (winnerIterator.hasNext()) {
            RaceCar winnerName = winnerIterator.next();
            assertThat(winnerName.toString()).isEqualTo(answerIterator.next());
        }

    }
}