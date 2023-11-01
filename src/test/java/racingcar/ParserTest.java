package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.util.Parser;

public class ParserTest {

    Parser parser = new Parser();
    /*  우테코 예시 코드 */
    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }


    @Test
    void parseStringToCarTest() {
        Parser parser = new Parser();
        List<String> carNames = List.of("car1", "car2", "car3");

        List<Car> cars = parser.parseStringToCar(carNames);

        assertEquals(3, cars.size());
        assertEquals("car1", cars.get(0).getName());
        assertEquals(0, cars.get(0).getPosition());
        assertEquals("car2", cars.get(1).getName());
        assertEquals(0, cars.get(1).getPosition());
        assertEquals("car3", cars.get(2).getName());
        assertEquals(0, cars.get(2).getPosition());
    }

    @Test
    void parseCarNameTest() {
        Parser parser = new Parser();
        List<String> carNames = parser.parseCarName("car1, car2, car3");

        assertEquals(3, carNames.size());
        assertEquals("car1", carNames.get(0));
        assertEquals("car2", carNames.get(1));
        assertEquals("car3", carNames.get(2));
    }

    @Test
    void assertParseCarNameWithWrongInputTest() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseCarName("dooooooo,tooooooo"));
        assertThrows(IllegalArgumentException.class, () -> parser.parseCarName(",ou,"));
        assertThrows(IllegalArgumentException.class, () -> parser.parseCarName("car1, 123456, car3"));
        assertThrows(IllegalArgumentException.class, () -> parser.parseCarName("333333333333333"));
        assertThrows(IllegalArgumentException.class, () -> parser.parseCarName("this,is,really,fun,hooooooo"));
    }

    @Test
    void parseAttemptTest() {
        Parser parser = new Parser();
        int attempt = parser.parseAttempt("5");

        assertEquals(5, attempt);
    }

    @Test
    void parseAttemptExceptionTest() {
        Parser parser = new Parser();
        assertThrows(IllegalArgumentException.class, () -> parser.parseAttempt("not a number"));
    }



}
