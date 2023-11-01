package racingcar;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void goOrNotTest(){
        Car testCar = new Car("test");

        testCar.goOrNot();
        System.out.println();
        System.out.println(testCar.name+" "+testCar.distance);
        System.out.println();
    }
}
