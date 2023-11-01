package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Referee;
import racingcar.domain.Winners;
import racingcar.utils.Parser;

public class GameTest {

    private final static int MAX_NAME_LENGTH = 5;
    private final static String SPLITTER = ",";

    @Test
    void 이름이_5글자가_넘어가는_경우_예외_발생() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("A".repeat(MAX_NAME_LENGTH + 1));

        String invalidName = stringBuilder.toString();
        assertThrows(IllegalArgumentException.class, () -> new Car(invalidName));
    }

    @Test
    void 이름이_5글자_이하인_경우_정상적으로_자동차가_등록() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("A".repeat(MAX_NAME_LENGTH));

        String validName = stringBuilder.toString();
        assertDoesNotThrow(() -> new Car(validName));
    }

    @Test
    void 이름이_공백인_경우_예외_발생() {
        String blank = " ";

        List<String> splitStringBySplitter = Parser.splitStringBySplitter(blank, SPLITTER);
        for (String name : splitStringBySplitter) {
            assertThrows(IllegalArgumentException.class, () -> new Car(name));
        }
    }

    @Test
    void 시도_횟수가_숫자가_아닌_경우_예외_발생() {
        String invalidInput = "not_number";

        assertThrows(IllegalArgumentException.class, () -> Parser.stringToInteger(invalidInput));
    }

    @Test
    void 자동차가_한_칸_전진할_경우_위치_증가() {
        Car car = new Car("name");
        car.moveForward();
        int expected = 1;

        assertEquals(expected, car.getLocation());

    }

    @Test
    void 우승자가_여러명일_경우_여러명_출력() {
        String nameOfFirstWinner = "one";
        String nameOfSecondWinner = "two";
        String nameOfNotWinner = "three";

        //given
        Car firstWinner = new Car(nameOfFirstWinner);
        Car secondWinner = new Car(nameOfSecondWinner);
        Car notWinner = new Car(nameOfNotWinner);

        List<Car> cars = List.of(firstWinner, secondWinner, notWinner);

        firstWinner.moveForward();
        secondWinner.moveForward();

        //when
        Referee referee = new Referee();
        Winners winners = referee.findWinners(cars);

        //then
        assertTrue(winners.toString().contains(nameOfFirstWinner) && winners.toString().contains(nameOfSecondWinner)
                && !winners.toString().contains(nameOfNotWinner));
    }

    @Test
    void 우승자가_한명일_경우_한명_출력() {
        String nameOfWinner = "one";
        String nameOfNotWinner = "two";

        //given
        Car winner = new Car(nameOfWinner);
        Car notWinner = new Car(nameOfNotWinner);

        List<Car> cars = List.of(winner, notWinner);

        winner.moveForward();

        //when
        Referee referee = new Referee();
        Winners winners = referee.findWinners(cars);

        //then
        assertTrue(winners.toString().contains(nameOfWinner)
                && !winners.toString().contains(nameOfNotWinner));
    }

}
