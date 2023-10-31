package racingcar.converter;

import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidNameException;
import racingcar.game.components.Car;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringToCarListConverterTest {

    private StringToCarListConverter converter = new StringToCarListConverter();

    @Test
    void execute() {
        String exceedLength = "mykhaylo,mudryk,sliva,jackson";
        assertThrows(InvalidNameException.class,
                () -> converter.execute(exceedLength));

        String validValue = "pobi,woni,jun";
        List<Car> carList = converter.execute(validValue);
        List<Car> userCarList = Arrays.asList(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun")
        );
        assertEquals(userCarList, carList);
    }
}