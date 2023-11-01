package racingcar.View;

import racingcar.Model.Car;

import java.util.List;
import java.util.Scanner;

public class RacingCarView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputCarNames() {
        System.out.println("차량 이름을 입력하세요. (이름은 쉼표로 구분)");
        String input = scanner.nextLine();
        return List.of(input.split(","));
    }

    public static int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public static void displayRoundResult(List<Car> cars) {
        System.out.println("라운드 결과:");
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public static void displayWinners(List<Car> winners) {
        System.out.print("최종 우승자: ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
