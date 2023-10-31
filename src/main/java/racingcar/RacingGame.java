package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();
    private int tryNum;
    private CheckInput check = new CheckInput();

    public void inputCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String str = Console.readLine();
        check.isBlank(str);
        String[] carsName = str.split(",");
        check.lenCheck(carsName);
        for (String s : carsName) {
            cars.add(new Car(s));
        }
    }

    public void inputTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryNumBeforeCheck = Console.readLine();
        tryNum = check.isInteger(tryNumBeforeCheck);
        check.isPositiveNum(tryNumBeforeCheck);
    }

    public int getTryNum() {
        return tryNum;
    }

    public void tryToMove() {
        for (Car c : cars) {
            c.move();
        }
    }

    public void printStatus() {
        for (Car c : cars) {
            c.status();
        }
        System.out.println();
    }

    public int locationOfWinner() {
        int max = 0;
        for (Car c : cars) {
            if (c.getLocation() > max) {
                max = c.getLocation();
            }
        }
        return max;
    }

    public int numOfWinner() {
        int winnerLocation = locationOfWinner();
        int numOfWinner = 0;
        for (Car c : cars) {
            if (c.getLocation() == winnerLocation) {
                numOfWinner++;
            }
        }
        return numOfWinner;
    }

    public void printWinner() {
        int winnerLocation = locationOfWinner();
        System.out.print("최종 우승자 : ");
        for (Car c : cars) {
            if (c.getLocation() == winnerLocation) {
                System.out.print(c.getName());
            }
        }
    }

    public void printWinners() {
        int winnerLocation = locationOfWinner();
        StringBuilder str = new StringBuilder("최종 우승자 :");
        for (Car c : cars) {
            if (c.getLocation() == winnerLocation) {
                str.append(" " + c.getName() + ",");
            }
        }
        System.out.println(str.substring(0, str.length() - 1));
    }
}
