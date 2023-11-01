package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    public int winnerCount = 0;
    public int outputCount = 0;
    public int MOVES;
    public static int MAX_LENGTH_OF_NAME = 5;
    public static int MIN_LENGTH_OF_NAME = 1;
    public static final String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    public static final String MOVES_MESSAGE = "시도할 회수는 몇회인가요?\n";
    public static final String OUTPUT_MESSAGE = "\n실행 결과\n";
    public static final String WINNER_MESSAGE = "최종 우승자 : ";
    public List<String> nameList = new ArrayList<>();
    public List<Car> carList = new ArrayList<>();


    public void getCarNames() {
        String input = Console.readLine();
        nameList = Arrays.asList(input.split(","));
        if (input.charAt(input.length() - 1) == ',') {
            throw new IllegalArgumentException("이름 입력은 쉼표로 끝낼 수 없습니다.");
        }
        if (nameList.size() == 1) {
            throw new IllegalArgumentException("자동차 이름은 1개 이상 입력해야 합니다.");
        }
        for (String name : nameList) {
            if (name.length() > MAX_LENGTH_OF_NAME) {
                throw new IllegalArgumentException("자동차 이름은 " + MAX_LENGTH_OF_NAME + "자 이하여야 합니다.");
            }
            if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 " + MIN_LENGTH_OF_NAME + "자 이상이어야 합니다.");
            }
        }
    }

    public void getNumberOfMoves() {
        MOVES = Integer.parseInt(Console.readLine());
    }

    public void printOutput() {
        for (Car car : carList) {
            System.out.print(car.name + " : ");
            for (int i = 0; i < car.count; i++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void whoIsWinner(List<Car> carList) {
        int max = 0;
        for (Car car : carList) {
            if (car.count >= max) {
                max = car.count;
            }
        }
        for (Car car : carList) {
            if (car.count == max) {
                car.win = true;
                winnerCount++;
            }
        }
    }

    public void printWinner(List<Car> carList) {
        for (Car car : carList) {
            if (car.win) {
                System.out.print(car.name);
                outputCount++;
            }
            if (outputCount == winnerCount) {
                System.out.print("\n");
                break;
            }
            if (car.win) {
                System.out.print(", ");
            }
        }
    }

    public void gameRun() {
        System.out.print(NAME_MESSAGE);
        getCarNames();
        System.out.print(MOVES_MESSAGE);
        getNumberOfMoves();
        for (String name : nameList) {
            carList.add(new Car(name));
        }
        System.out.print(OUTPUT_MESSAGE);
        for (int i = 0; i < MOVES; i++) {
            for (Car car : carList) {
                car.move();
            }
            printOutput();
        }
        whoIsWinner(carList);
        System.out.print(WINNER_MESSAGE);
        printWinner(carList);
    }

}
