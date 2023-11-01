package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    @DisplayName("생성 테스트")
    public void getValueTest(){
        Car car1 = new Car("pobi");
        assertEquals("pobi", car1.getName());
    }
}
