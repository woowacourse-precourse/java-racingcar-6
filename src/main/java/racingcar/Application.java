package racingcar;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = readLine().split(",");
        if (!isNameValid(carNames)) {
            throw new IllegalArgumentException();
        }

        List<Car> Cars = new ArrayList<>();
        for (String carName : carNames) {
            Car tmpCar = new Car(carName);
            Cars.add(tmpCar);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String turnCnt = readLine();
        if (!isCntValid(turnCnt)) {
            throw new IllegalArgumentException();
        }
        System.out.println();

        int cnt = Integer.parseInt(turnCnt);
        while (cnt > 0) {
            for (Car curCar : Cars) {
                curCar.takeTurn();
                printResult(curCar);
            }
            System.out.println();
            cnt--;
        }

        int maxDistance = getMaxDistance(Cars);
        List<String> winners = new ArrayList<>();
        for (Car curCar : Cars) {
            if (curCar.distance == maxDistance) {
                winners.add(curCar.name);
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public static boolean isNameValid(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static boolean isCntValid(String cnt) {
        if (cnt.matches("[0-9]+")) {
            if (cnt.equals("0")) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static void printResult(Car curCar) {
        System.out.print(curCar.name + " : ");
        for (int i = 0; i < curCar.distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static int getMaxDistance(List<Car> Cars) {
        int maxDistance = 0;
        for (Car curCar : Cars) {
            if (curCar.distance > maxDistance) {
                maxDistance = curCar.distance;
            }
        }
        return maxDistance;
    }
}

