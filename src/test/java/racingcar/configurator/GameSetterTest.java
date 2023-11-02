package racingcar.configurator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameSetterTest {

    private GameSetter gameSetter;
    private Cars carList;

    @BeforeEach
    public void setUp() {
        carList = new Cars();

        String userInputValue = "Car1,Car2,Car3";
        int coin = 5;

        gameSetter = new GameSetter(carList, userInputValue, coin);
    }

    @Test
    public void testRegisterCars() {
        gameSetter.registerCars();

        assertEquals(3, carList.size());
        assertEquals("Car1", carList.get(0).getName());
        assertEquals("Car2", carList.get(1).getName());
        assertEquals("Car3", carList.get(2).getName());
    }

    @Test
    public void testInputCarToList() {
        gameSetter.inputCarToList("Car4");

        assertEquals(1, carList.size());
        assertEquals("Car4", carList.get(0).getName());
    }

    @Test
    public void testValidateNameLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            gameSetter.validateNameLength("ThisNameIsTooLong");
        });
    }

    @Test
    public void testGetCoin() {
        assertEquals(5, gameSetter.getCoin());
    }
}
