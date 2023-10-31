package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class RacingCar {

    public List<String> cars = new ArrayList<>();
    public Map<String, String> gameScore = new HashMap<>();
    ExceptionCase exception = new ExceptionCase();

    public String nameInput() {
        return Console.readLine().trim();
    }
    public List<String> setCarName() {
        String[] racers = stringToList();
        cars = Arrays.asList(racers);
        return cars;
    }
    //for test
    public List<String> setCarName(String input) {
        exception.nullStringInput(input);
        exception.carNameLength(input);
        String[] racers = input.split(",");
        cars = Arrays.asList(racers);
        exception.hasAtLeastTwoInputs(racers);
        return cars;
    }

    public String[] stringToList() {
        String input = nameInput();
        exception.carNameLength(input);
        exception.nullStringInput(input);
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
