package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class RacingCar {

    public List<String> cars = new ArrayList<>();
    public Map<String, String> gameScore = new HashMap<>();
    ExceptionCase exception = new ExceptionCase();

    public String nameInput() {
        String input = Console.readLine().trim();
        input = exception.nullStringInput(input);
        return input;
    }
    public List<String> setCarName() {
        String[] racers = stringToList();
        racers = exception.nameInputValidation(racers);
        cars = Arrays.asList(racers);
        return cars;
    }

    public String[] stringToList() {
        String input = nameInput();
        String[] racers = input.split(",");
        return racers;
    }


    public Map<String, String> createRaceStatusMap() {
        for (String car : cars) {
            gameScore.put(car, "");
        }
        return gameScore;
    }

    public int attemptCountInput() {
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
