package View;

import Model.Car;
import Model.CarList;
import camp.nextstep.edu.missionutils.Console;

public class GameView {
    private static final String ONE_MOVE = "-";

    public static String getRaceCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static String getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public static void printGameResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printCarState(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 1; i <= car.getPosition(); i++) {
            System.out.print(ONE_MOVE);
        }
        System.out.println();
    }

    public static void printLine() {
        System.out.println();
    }

    public static void printRaceWinners(CarList raceWinners) {
        System.out.print("최종 우승자 : ");
        int len = raceWinners.getSize();
        for (int i = 0; i < len; i++) {
            Car car = raceWinners.getCar(i);
            System.out.print(car.getName());
            if (i != len - 1) {
                System.out.print(", ");
            }
        }
    }
}
