package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputMessage {
    private static final String GAME_RESULT_MESSAGE = "실행 결과";

    public static void printGameResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public static void printRandomPlayResultPositionMessage(Car car) {
        System.out.print(car.getName() + " : ");
        System.out.println("-".repeat(car.getPosition()));
    }

    public static void printWinnerMessage(List<Car> winnerList) {
        System.out.print("최종 우승자 : ");

        if (winnerList.size() == 1) {
            System.out.println(winnerList.get(0).getName());
            return;
        }

        for (int i = 0; i < winnerList.size(); i++) {
            System.out.print(winnerList.get(i).getName());
            if (i != winnerList.size()-1) {
                System.out.print(", ");
            }
        }
    }

    public static void printLn() {
        System.out.println();
    }
}