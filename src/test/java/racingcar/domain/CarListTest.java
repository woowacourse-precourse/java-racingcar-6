package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


class CarListTest {

    @Test
    void stringToCarListTest() {
        //given
        String carNames = "zizi,hoho,haha";
        List<Car> testCarList = new ArrayList<>();
        testCarList.add(new Car("zizi"));
        testCarList.add(new Car("hoho"));
        testCarList.add(new Car("haha"));
        //when
        CarList carList = new CarList(carNames);
        
        //then
        assertEquals(carList.toString(), testCarList.toString());
    }

}