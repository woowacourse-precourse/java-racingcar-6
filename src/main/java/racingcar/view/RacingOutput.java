package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class RacingOutput {
    public static void printStartRacing() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printInputTryNumberMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printProcessResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printWinnerMessage(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public static void printProcessResult(List<Car> racingCar) {
        for (var car : racingCar) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }
        System.out.println();
    }
}
