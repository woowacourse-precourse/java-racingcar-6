/*package controller;

import camp.nextstep.edu.missionutils.Randoms;
import model.Car;

import model.CarList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.UserView;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GameControllerTest {

    private GameController gameController;
    private UserView userController;
    private CarList carList;

    @BeforeEach
    public void setUp() {
        userController = Mockito.mock(UserView.class);
        gameController = new GameController(userController, carList);
    }

    @Test
    public void testPlayRound() {
        mockStatic(Randoms.class);

        CarList cars = carList;
        Car car1 = Mockito.mock(Car.class);
        Car car2 = Mockito.mock(Car.class);
        cars.addCar(car1);
        cars.addCar(car2);

        when(Randoms.pickNumberInRange(0, 9)).thenReturn(5);

        gameController.playRound();

        verify(car1, times(1)).moveForward();
        verify(car2, times(1)).moveForward();
    }

    @Test
    public void testCalculateWinner() {
        ArrayList<Car> cars = new ArrayList<>();

        Car car1 = new Car("Car1");
        car1.moveForward();

        Car car2 = new Car("Car2");
        car2.moveForward();

        cars.add(car1);
        cars.add(car2);

        String winnerName = gameController.calculateWinner();

        assertEquals("Car1, Car2", winnerName);
    }
}
*/