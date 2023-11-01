package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

public class CircuitTest extends NsTest {
    private ArrayList<Car> cars;

    @BeforeEach
    private void setUp(){
        cars = new ArrayList<>();
        cars.add(new Car("Car1", 0));
        cars.add(new Car("Car2", 0));
    }

    @Test
    private void testRandomDistance(){
        Circuit circuit=new Circuit(cars);
        boolean result=circuit.RandomDistance();

        assertTrue(result==true||result==false);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
