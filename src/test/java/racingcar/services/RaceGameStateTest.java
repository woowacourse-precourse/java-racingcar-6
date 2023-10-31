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

}