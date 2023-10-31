package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.gameInfo.InputManager;
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

    @Test
    @DisplayName("자동차의 길이가 5 이상에서 에러가 발생하는지 확인")
    public void 자동차길이_5이상() throws Exception {
        try {
            new InputManager(5, "pobi,woni,too long");
            fail("문자열의 길이가 5이상이 아님");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    @DisplayName("자동차의 길이가 0 이하에서 에러가 발생하는지 확인")
    public void 자동차길이_0이하() throws Exception {
        try {
            new InputManager(5, "pobi, ,jun");
            fail("문자열이 공백이 아님");
        } catch (IllegalArgumentException e) {

        }

        try {
            new InputManager(5, "pobi,,jun");
            fail("문자열이 공백이 아님");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    @DisplayName("중복되는 자동차가 있는지 확인")
    public void 중복되는_자동차_확인() throws Exception {
        try {
            new InputManager(5, "pobi,woni,pobi");
            fail("중복되는 자동차가 없다.");
        } catch (IllegalArgumentException e) {

        }
    }

}
