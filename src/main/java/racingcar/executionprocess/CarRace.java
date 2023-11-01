package racingcar.executionprocess;

import java.util.List;

import racingcar.input.CarName;
import racingcar.input.NumberOfAttempts;



public class CarRace {
    private static List<String> cars;
    private static int number;

    public static void start() {
        printCarName();
        printNumberOfAttempts();
        printResult();
    }

    private static void printCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        cars = CarName.input();
    }

    private static void printNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        number = NumberOfAttempts.input();
        System.out.println();
        System.out.println("실행 결과");
    }

    private static void printResult() {
        int[] move = new int[cars.size()];
        Result result = new Result(move);
        for (int i = 0; i < number; i++) {
            try {
                result.output(cars);
                System.out.println();
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.print("최종 우승자 : " + result.findWinner(cars));

    }
}
