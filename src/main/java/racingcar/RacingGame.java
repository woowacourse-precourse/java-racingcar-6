package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;

public class RacingGame {
    ArrayList<Car> carArrayList = new ArrayList<>();
    Integer count = 0;

    public void start() {
        getInputCarName();
        getInputCount();
        race();
        printWinners();
    }

    private void race() {
        for (int i = 0; i < this.count; i++) {
            executeOneTurn();
            printOneTurn();
        }
    }

    private void executeOneTurn() {
        for (Car car : carArrayList) {
            car.goOrStop();
        }
    }

    private void printOneTurn() {
        for (Car car : carArrayList) {
            car.printState();
        }
        System.out.println();
    }

    private void printWinners() {
        // 우승자 출력
        System.out.print("최종 우승자 : ");
        Collections.sort(carArrayList);
        int max = carArrayList.get(0).distance;
        int cnt = 0;
        for (Car c: carArrayList) {
            if (c.distance == max) cnt++;
        }
        for (int i = 0; i < cnt; i++) {
            System.out.print(carArrayList.get(i).name);
            if (i != cnt-1) {
                System.out.print(", ");
            }
        }
    }

    private void getInputCount() {
        // 시도할 횟수 입력
        System.out.println("시도할 회수는 몇회인가요?");
        String input;
        input = Console.readLine();
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
            carArrayList.add(new Car(s, 0));
        }
    }
}

