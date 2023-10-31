package util.stringconverter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static resource.TestData.CAR_NAME_1;

import org.junit.jupiter.api.Test;
import racingcar.model.CarPlayerModel;

public class CarConverterTest {
    @Test
    void toString_메서드_정상적인_입력() {
        CarConverter converter = new CarConverter();
        CarPlayerModel car = new CarPlayerModel(CAR_NAME_1);
        String carString = converter.toString(car);
        assertEquals(CAR_NAME_1, carString);
    }

    @Test
    void toString_메서드_null_입력() {
        CarConverter converter = new CarConverter();
        CarPlayerModel car = null;
        assertThrows(NullPointerException.class, () -> converter.toString(car));
    }

    @Test
    void fromString_메서드_정상적인_입력() {
        CarConverter converter = new CarConverter();
        CarPlayerModel car = converter.fromString(CAR_NAME_1);
        assertEquals(CAR_NAME_1, car.getCarName());
    }
}
