package racingcar;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarFactoryTest {

    @Test
    public void testProduction() {
        String[] carNames = {"Kim", "Seo", "Park"};
        MyCar[] cars = CarFactory.production(carNames);

        assertNotNull(cars);
        assertEquals(carNames.length, CarFactory.getProductionQuantity());

        for (int i = 0; i < carNames.length; i++) {
            assertEquals(carNames[i], cars[i].getCarName());
        }
    }

    @Test
    public void testGetProductionQuantity() {
        String[] carNames = {"Kim", "Seo"};
        MyCar[] cars = CarFactory.production(carNames);

        assertEquals(carNames.length, CarFactory.getProductionQuantity());

        String[] moreCarNames = {"Park", "Lee"};
        MyCar[] moreCars = CarFactory.production(moreCarNames);

        assertEquals(moreCarNames.length, CarFactory.getProductionQuantity());
    }
}
