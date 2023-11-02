package racingcar.ControllerTest;

import camp.nextstep.edu.missionutils.Console;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import racingcar.Controller.RacingCarGameController;
import racingcar.Model.Car;

public class RacingCarGameControllerTest {
    private RacingCarGameController controller = new RacingCarGameController();
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    public void testCreateRacingCar() {
        List<String> carNameList = Arrays.asList("Car1", "Car2", "Car3");

        List<Car> carList = controller.createRacingCar(carNameList);

        assertEquals(3, carList.size());
        assertEquals("Car1", carList.get(0).getName());
        assertEquals("Car2", carList.get(1).getName());
        assertEquals("Car3", carList.get(2).getName());
    }

    @Test
    public void testStartGame() {
        List<Car> carList = Arrays.asList(
                new Car("Car1"),
                new Car("Car2"),
                new Car("Car3")
        );

        controller.startGame(carList, "3");

        for (Car car : carList) {
            assertTrue(car.getMoveCount() <= 3); // 3 또는 그 이하의 움직임
        }
    }


    // 나머지 메서드에 대한 테스트도 유사한 방식으로 작성 가능
    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
