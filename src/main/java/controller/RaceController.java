package controller;


import camp.nextstep.edu.missionutils.Console;
import service.RaceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class RaceController {

    private RaceService raceService = new RaceService();

    public Map<String, Integer> checkName() {
        String inputValue = Console.readLine();
        String[] names = inputValue.split(",");
        return raceService.validateNames(names);
    }

    public int attemptCount() {
        String inputValue = Console.readLine();
        return raceService.validateAttemptCount(inputValue);

    }

    public Map<String, Integer> raceStart(Map<String, Integer> racer) {
        return raceService.raceStart(racer);
    }

    public List<String> raceWinner(Map<String, Integer> raceResult) {

        return raceService.raceWinner(raceResult);

    }
}