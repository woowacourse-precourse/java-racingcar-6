package racingcar;

import racingcar.Domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Output {
    static final String guideCarNameMessage = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    static final String guideTryCountMessage = "시도할 회수는 몇회인가요?";
    static final String resultMessage = "\n실행 결과";
    static final String winnerMessage = "최종 우승자 : ";

    public static void printGuideCarName() {
        System.out.println(guideCarNameMessage);
    }

    public static void printGuideTryCount() {
        System.out.println(guideTryCountMessage);
    }

    public static void printResultMessage() {
        System.out.println(resultMessage);
    }

    public static void printResult(List<Car> cars) {
        for(Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition().intValue()));
        }
        System.out.println();
    }

    public static void printWinner(List<Car> cars) {
        System.out.print(winnerMessage);
        for(Car car : cars) {
            System.out.print(car.getName());
            if (cars.indexOf(car) != cars.size() - 1) {
                System.out.print(", ");
            }
        }
    }

}
