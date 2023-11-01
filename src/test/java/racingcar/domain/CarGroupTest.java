package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarGroupTest {

    @Test
    public void 정상적인_Gar_Group_테스트() {
        CarGroup carGroup = new CarGroup();
        carGroup.addCar(new Car("woo"));
        carGroup.addCar(new Car("te"));
        carGroup.addCar(new Car("co"));

        assertEquals(3, carGroup.getCarGroupSize());
    }
}
