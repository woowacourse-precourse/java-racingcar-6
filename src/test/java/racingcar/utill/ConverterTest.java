package racingcar.utill;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class ConverterTest {

    @Test
    void attemptStringToIntConvertTest() {
        //given
        String convertNumber = "13";

        //when
        int convertedNumber = Converter.attemptStringToIntCovert(convertNumber);

        //then
        assertEquals(convertedNumber, 13);
    }

    @Test
    void stringToCarListConvert() {
        //given
        String covertString = "hoho,hihi,haha";
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("hoho"));
        carList.add(new Car("hihi"));
        carList.add(new Car("haha"));

        //when
        List<Car> convertedString = Converter.stringToCarListConvert(covertString);
        
        //then
        assertEquals(convertedString.toString(), carList.toString());
    }

}