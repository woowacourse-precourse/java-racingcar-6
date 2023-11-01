package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Racing {
    public static void play() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        List<Car> cars = Validate.validateCarName(names);

        System.out.println("시도할 회수는 몇회인가요?");
        String strNumberOfMoves = Console.readLine();
        int numberOfMoves = Validate.checkNumber(strNumberOfMoves);

        while (numberOfMoves-- > 0) {
            judgeMoving(cars);
            printRound(cars);
        }
        System.out.println("최종 우승자 : " + getWinner(cars));
    }

    public static String getWinner(List<Car> cars) {
            List<String> winners = new ArrayList<>();
            int maxMovingCnt = getMaxMovingCnt(cars);
            for (Car car : cars) {
                if (car.getMovingCnt() == maxMovingCnt) {
                    winners.add(car.getName());
                }
            }
            return String.join(",", winners);
    
    }

    public static void printRound(List<Car> cars) {
        for (Car car : cars) {
            car.printResult();
        }
        System.out.println();
    }

    public static int getMaxMovingCnt(List<Car> cars) {
        return cars.stream()
                .max(Car::compareTo)
                .get().getMovingCnt();
    }

    public static void judgeMoving(List<Car> cars) {
        for (Car car : cars) {
            int randomValue = GenerateRandomeNumber.generateNumber();
            if (randomValue >= 4) {
                car.moveForward();
            }
        }
    }
}
