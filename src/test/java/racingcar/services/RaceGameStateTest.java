package racingcar.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.services.RaceGameState;

class RaceGameStateTest {

    @Test
    @DisplayName("입자받은 문자열을 통해 Map으로 변환 테스트")
    void convertInputStringToMapTest() {
        //given
        String sampleInput = "pobi, woni, kim  ";
        Map<String, Integer> expected = Map.of("pobi",0, "woni", 0,"kim",0);
        //when
        RaceGameState state = new RaceGameState(sampleInput);
        //then
        Map<String, Integer> converted = state.getStateOfEachCar();
        assertEquals(expected, converted);
    }

    @Test
    @DisplayName("차 이름을 입력받고 한번의 전진 테스트")
    void goForwardByNameTest() {
        //given
        String sampleInput = "pobi, woni, kim";
        RaceGameState state = new RaceGameState(sampleInput);
        //when
        state.moveForwardByName("pobi");
        //then
        int expected = 1;
        int actual = state.getStateOfEachCar().get("pobi");
        assertEquals(expected, actual);
     }
}