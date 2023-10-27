package view;

import action.Car;
import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    public static void startMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }

    public static void askTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void result() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printResult(Car car) {
        System.out.println(car.getCarName() + " : " + car.getStatus());
    }

    public static void printWinner(List<String> winners) {
        StringJoiner delimiter = new StringJoiner(",");
        for (String car : winners) {
            delimiter.add(car);
        }

        System.out.println("최종 우승자 : " + delimiter);
    }

}
