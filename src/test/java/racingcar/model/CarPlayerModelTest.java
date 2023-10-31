package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static resource.TestData.CAR_NAME_1;
import static resource.TestData.ONE;

import org.junit.jupiter.api.Test;

public class CarPlayerModelTest {
    @Test
    void move_움직일_수_있는_경우() {
        CarPlayerModel car = new CarPlayerModel(CAR_NAME_1);
        CarPlayerModel spyCar = spy(car);
        doReturn(true).when(spyCar).isMoveAllowed();
        int initialPosition = spyCar.getCurrentPosition();
        spyCar.move();
        int finalPosition = spyCar.getCurrentPosition();
        assertEquals(initialPosition + ONE, finalPosition);
    }

    @Test
    void move_움직일_수_없는_경우() {
        CarPlayerModel car = new CarPlayerModel(CAR_NAME_1);
        CarPlayerModel spyCar = spy(car);
        doReturn(false).when(spyCar).isMoveAllowed();
        int initialPosition = spyCar.getCurrentPosition();
        spyCar.move();
        int finalPosition = spyCar.getCurrentPosition();
        assertEquals(initialPosition, finalPosition);
    }
}
