package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCar {
    ExceptionCase exception = new ExceptionCase();

    public String nameInput() {
        return Console.readLine().trim();
    }

    public List<String> naming(String input) {
        exception.nullStringInput(input);
        String[] racers = input.split(",");
        List<String> cars = Arrays.asList(racers);
        exception.carNameLength(cars);
        return cars;
    }

    public Map<String, String> createRaceStatusMap(List<String> cars) {
        Map<String, String> gameScore = new HashMap<>();
        for (String car : cars) {
            gameScore.put(car, "");
        }
        return gameScore;
    }

    public int attemptInput() {
        try {
            String attempt = Console.readLine().trim();
            exception.nullStringInput(attempt);
            int num = Integer.parseInt(attempt);
            exception.isNumberCorrect(num);
            return num;
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요");
        }
    }

}
