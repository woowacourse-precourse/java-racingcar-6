package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.List;

public class ConsoleWrapper {
    public static String promptCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분): ");
        return Console.readLine();
    }

    public static int promptNumOfMoves() {
        System.out.println("시도할 회수는 몇 회인가요?: ");
        try {
            // 1. 사용자로부터 시도 횟수를 입력받습니다.
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            // 2. 올바르지 않은 입력 예외 처리
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
        }
    }

    public static void printCarStatus(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            printCarStatus(car);
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}