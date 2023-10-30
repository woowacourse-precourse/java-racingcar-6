package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.InputManager;
import racingcar.domain.car.Car;

public class InputManagerTest {
    private InputManager inputManager;

    @BeforeEach
    public void initInputManager() {
        inputManager = new InputManager(5, "pobi,woni,jun");
    }

    @Test
    @DisplayName("게임 횟수 입력")
    public void 게임_횟수_입력() throws Exception {
        assertEquals(5, inputManager.getGameProcessCount());
    }

    @Test
    @DisplayName("문자열이 올바르게 파싱되었는지 확인")
    public void 자동차리스트_파싱() throws Exception {
        //given
        List<Car> parsedCarList = inputManager.getParsedCarList();

        assertEquals(3, parsedCarList.size());
        assertTrue(parsedCarList.stream().anyMatch(car -> car.getName().equals("pobi")));
        assertTrue(parsedCarList.stream().anyMatch(car -> car.getName().equals("woni")));
        assertTrue(parsedCarList.stream().anyMatch(car -> car.getName().equals("jun")));
    }


}
