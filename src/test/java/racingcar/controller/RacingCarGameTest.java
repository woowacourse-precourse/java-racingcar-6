package racingcar.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.Test;

public class RacingCarGameTest {
    public RacingCarGame racingCarGame = new RacingCarGame();
    @Test
    public void TestDecideForward(){
        Map<String, Integer> car = new HashMap<>();
        car.put("Car", 0);
        racingCarGame.decideForward(3, "Car");
        assertEquals(0, car.get("Car"));
    }
    @Test
    public void testGameResult() {
        Map<String, Integer> car = new HashMap<>();
        car.put("Car1", 5);
        car.put("Car2", 3);
        car.put("Car3", 5);
        racingCarGame.setCar(car);

        racingCarGame.gameResult();
        assertEquals(2, racingCarGame.getWinner().size());
    }
    @Test
    public void testCalculate() {
        Entry<String, Integer> entry = Map.entry("Car", 5);
        int maxDistance = 5;

        racingCarGame.calculate(entry, maxDistance);

        assertTrue(racingCarGame.getWinner().contains("Car"));
    }
}
