package racingcar.racingTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import racingcar.controller.GameController;

public class RaceTest {

    @Test
    void 전진_리스트_생성_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        GameController gameController = new GameController();
        Method method = gameController.getClass().getDeclaredMethod("createMovementList",List.class);
        method.setAccessible(true);

        List<String> carNames = List.of("pobi","woni");
        List<Integer> movement = (List<Integer>) method.invoke(gameController,carNames);

        assertEquals(carNames.size(),movement.size());
    }

    @Test
    void 승리자_여러명_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        GameController gameController = new GameController();
        Method method = gameController.getClass().getDeclaredMethod("racingResult", List.class, List.class);
        method.setAccessible(true);

        List<String> carNames = List.of("pobi", "woni", "jazz");
        List<Integer> movement = List.of(2, 2, 1);

        List<String> winners = (List<String>) method.invoke(gameController, carNames, movement);

        List<String> expectedWinners = List.of("pobi", "woni");
        assertEquals(expectedWinners, winners);
    }



}
