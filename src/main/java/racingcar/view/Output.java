package racingcar.view;

import racingcar.repository.Car;

import java.util.List;

public class Output {
    public static void askNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void askRoundMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void resultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void racingMessage(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + car.getDistance());
        }
        System.out.println();
    }

    public static void winnerMessage(List<String> winnerList) {
        System.out.print("최종 우승자 : ");
        String result = String.join(", ", winnerList);
        System.out.println(result);
    }
}
