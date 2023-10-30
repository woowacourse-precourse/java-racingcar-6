package racingcar;

import java.util.List;

public class OutputManager {
    public static void printRoundResult(int round, List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + createPositionString(car.getPosition()));
        }
        System.out.println();
    }

    private static String createPositionString(int position) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }

    public static void printWinners(List<Car> winners) {
        System.out.print("우승자: ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
