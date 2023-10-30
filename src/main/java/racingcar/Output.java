package racingcar;

import java.util.List;

public class Output {
    public static void startMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void roundMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void resultStartMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printResult(List<Car> carName) {
        for (Car car : carName) {
            System.out.println(car.getName() + " : " + car.getDistance());
        }
        System.out.println();
    }

    public static void printWinner(List<Car> carName) {
        String result = String.join(", ", WhoIsWinner.compareDistance(carName));
        System.out.println("최종 우승자 : " + result);
    }
}
