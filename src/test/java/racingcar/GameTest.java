package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
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
    void 시도_횟수가_숫자가_아닌_경우_예외가_던져지는지() {
        String invalidInput = "not_number";

        assertThrows(IllegalArgumentException.class, () -> Parser.stringToInteger(invalidInput));
    }

    @Test
    void 자동차가_한_칸_전진할_경우_위치가_증가하는지() {
        Car car = new Car("name");
        car.moveForward();
        int expected = 1;

        assertEquals(expected, car.getLocation());

    }
}
