package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static racingcar.Resource.carNamesMessage;
import static racingcar.Resource.attemptsMessage;


public class Start {
    private int attempts;
    private ArrayList<String> carList;

    public void getInput() {
        System.out.println(carNamesMessage);
        String cars = Console.readLine();
        carList = new ArrayList<>();

        List<String> inputList = Arrays.asList(cars.split(","));
        Set<String> inputSet = new HashSet<>(inputList);

        if (inputList.size() != inputSet.size()) {
            throw new IllegalArgumentException("입력된 자동차 이름에 중복이 포함되어 있습니다.");
        }

        for (String input : inputList) {
            if (input.length() >= 6) {
                throw new IllegalArgumentException("입력된 자동차 이름이 6자리 이상입니다.");
            }
            if (input.isEmpty()) {
                throw new IllegalArgumentException("입력된 자동차 이름에 공백이 포함되어 있습니다.");
            }
            carList.add(input);
        }

        System.out.println(attemptsMessage);
        String numberAttemptsStr = Console.readLine();

        try {
            attempts = Integer.parseInt(numberAttemptsStr);
            if (attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 정수를 입력하세요.");
        }

    }

    public ArrayList<String> getCarList() {
        return carList;
    }

    public int getNumberAttempts() {
        return attempts;
    }

}
