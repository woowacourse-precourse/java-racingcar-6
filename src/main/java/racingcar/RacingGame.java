package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class RacingGame {
    ArrayList<Car> carList = new ArrayList<>();
    ArrayList<String> winnerList = new ArrayList<>();
    Integer count = 0;

    public void play() {
        getInputCarName();
        getInputCount();
        race();
        judgeWinners();
        printWinners();
    }

    private void getInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validateCareName(input);

        ArrayList<String> nameList = new ArrayList<>(Arrays.asList(input.split(",")));
        for (String s : nameList) {
            carList.add(new Car(s, 0));
        }
    }

    static private void validateCareName(String input) {
        ArrayList<String> nameList = new ArrayList<>(Arrays.asList(input.split(",")));
        if (nameList.size() < 2 || nameList.size() > 10) {
            throw new IllegalArgumentException("2대 이상 10대 이하의 자동자 이름을 입력해주세요.");
        }
        for (String name : nameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하입니다.");
            }
        }
        HashSet<String> numSet = new HashSet<>(nameList);
        if (numSet.size() != nameList.size()) {
            throw new IllegalArgumentException("자동차 이름이 중복됩니다.");
        }
    }

    private void getInputCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        validateCount(input);
        this.count = Integer.parseInt(input);
        System.out.println();
    }

    static private void validateCount(String input) {
        String regExp = "^[0-9]+$";
        if (!input.matches(regExp)) {
            throw new IllegalArgumentException("양의 정수만 입력 가능합니다.");
        }
        if (input.length() > 9) {
            throw new IllegalArgumentException("아홉 자리 이내 숫자만 입력 가능합니다.");
        }
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("0 이상의 숫자만 입력 가능합니다.");
        }
    }

    private void race() {
        for (int i = 0; i < this.count; i++) {
            executeOneTurn();
            printOneTurn();
        }
    }

    private void executeOneTurn() {
        for (Car car : carList) {
            car.goOrStop();
        }
    }

    private void printOneTurn() {
        for (Car car : carList) {
            car.printState();
        }
        System.out.println();
    }

    private void judgeWinners() {
        Collections.sort(carList);
        int max = carList.get(0).distance;
        for (Car c : carList) {
            if (c.distance == max) {
                winnerList.add(c.name);
            }
        }
    }

    private void printWinners() {
        System.out.println("최종 우승자 : " + String.join(", ", winnerList));
    }
}

