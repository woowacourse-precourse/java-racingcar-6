package racingcar.Service;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Domain.Car;
import racingcar.Domain.Game;

public class GameFlowManagementServiceTest {
    private GameFlowManagementService gameFlowManagementService;

    @BeforeEach
    void setUp() {
        gameFlowManagementService = new GameFlowManagementService();
    }

    @Test
    void testGetFurthestCarList_가장_멀리간_차_목록()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");

        car1.driveForward(3); // Car1이 가장 멀리 간 상태

        Game game = new Game(List.of(car1, car2), 5);

        Method method = GameFlowManagementService.class.getDeclaredMethod("getFurthestCarList", List.class, int.class);
        method.setAccessible(true);

        List<String> furthestCars = (List<String>) method.invoke(gameFlowManagementService, game.getCarList(), 3);

        assertThat(furthestCars).containsExactly("pobi");
    }
}