package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class Car {
    String name;
    int count;

    public Car(String name) {
        this.name = name;
        this.count = 0;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.count++;
        }
    }

    public void printCounts() {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
    }

    public void printMoves() {
        System.out.print(this.name + " : ");
        printCounts();
        System.out.print("\n");
    }
}

class Game {
    public static int MOVES;
    public static final String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    public static final String MOVES_MESSAGE = "시도할 회수는 몇회인가요?\n";
    public static final String OUTPUT_MESSAGE = "실행 결과\n";
    public static final String WINNER_MESSAGE = "최종 우승자 : ";
    List<String> nameList;
    List<Car> carList;

    public void getCarNames() {
        String input = Console.readLine();
        nameList = Arrays.asList(input.split(","));
    }

    public void getNumberOfMoves() {
        MOVES = Integer.parseInt(Console.readLine());
    }

    public void printOutput() {
        for (Car car : carList) {
            System.out.print(car.name+" : ");
            for(int i = 0; i<car.count; i++){
                System.out.print("-");
            }
        }
        System.out.print("\n");
    }

    public void gameRun() {
        for (String name : nameList) {
            carList.add(new Car(name));
        }
        System.out.print(OUTPUT_MESSAGE);
        for (int i = 0; i < MOVES; i++) {

            for (Car car : carList) {
                car.move();
            }
            // TODO : 결과 출력

        }
    }
}
