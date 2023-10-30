package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;

public class RacingGame {
    ArrayList<Car> carList = new ArrayList<>();
    ArrayList<String> winnerList = new ArrayList<>();
    Integer count = 0;

    public void start() {
        getInputCarName();
        getInputCount();
        race();
        judgeWinners();
        printWinners();
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

    private void getInputCount() {
        // 시도할 횟수 입력
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        // 몇대까지 가능하게 할 것인가?
        this.count = Integer.parseInt(input);
        System.out.println();

    }

    private void getInputCarName() {
        // 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        // 몇대까지 가능하게 할 것인가?
        String[] nameList = input.split(",");
        for (String s : nameList) {
            if (s.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하입니다.");
            }
            carList.add(new Car(s, 0));
        }
    }
}

