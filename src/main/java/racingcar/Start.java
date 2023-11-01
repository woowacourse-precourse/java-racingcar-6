package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Start {
    private int attempts;
    private ArrayList<String> carList;

    public void getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String car = Console.readLine();
        carList = new ArrayList<>();

        List<String> inputList = Arrays.asList(car.split(","));
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

        System.out.println("시도할 회수는 몇회인가요?");
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
