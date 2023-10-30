package study;

import controller.RaceController;
import exception.RaceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.RaceService;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;

public class RaceTest {

    RaceService raceService;
    RaceController raceController;

    @BeforeEach
    public void setup() {
        raceService = new RaceService();
    }

    @Test
    public void 자동차_생성_테스트() {
        Map<String, Integer> racer = raceService.validateNames(new String[]{"pobi"});
        assertTrue(racer.containsKey("pobi"));
        assertEquals(0, racer.get("pobi"));
    }

    @Test
    public void 이름_길이_초과_테스트() {
        assertThrows(RaceException.class, () -> raceService.validateNames(new String[]{"pobipobi"}));
    }

    @Test
    public void 경주_횟수_설정_테스트() {
        int attempts = raceService.validateAttemptCount("3");
        assertEquals(3, attempts);
    }

    @Test
    public void 숫자_아닌_값_테스트() {
        assertThrows(RaceException.class, () -> raceService.validateAttemptCount("three"));
    }

    @Test
    public void 음수_값_테스트() {
        assertThrows(RaceException.class, () -> raceService.validateAttemptCount("-3"));
    }

    @Test
    public void 동명이인_처리_테스트() {
        Map<String, Integer> racer = raceService.validateNames(new String[]{"pobi", "pobi"});
        assertTrue(racer.containsKey("pobi"));
        assertTrue(racer.containsKey("pobi_1"));
    }
    @Test
    public void 경주_테스트(){
        int attempts = raceService.validateAttemptCount("3");
        assertTrue(attempts==3);
    }
    @Test
    public void 우승자_결정_테스트() {
        Map<String, Integer> racer = raceService.validateNames(new String[]{"pobi", "woni"});
        racer.put("pobi", 5);
        racer.put("woni", 3);
        assertTrue(raceService.raceWinner(racer).contains("pobi"));

        // 여기에서 우승자를 결정하는 로직을 호출하고, 결과가 "pobi"임을 확인해야 합니다.
        // 현재 코드에서는 해당 로직이 누락되어 있어서 테스트 코드를 완성할 수 없습니다.
    }
}
