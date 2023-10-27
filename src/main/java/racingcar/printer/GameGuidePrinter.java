package racingcar.printer;

import racingcar.domain.Car;

import java.util.List;

public class GameGuidePrinter {
    private static final String carNameInputMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String tryCountMessage = "시도할 회수는 몇회인가요?";
    private static final String resultMessage = "실행 결과";
    private static final String finalWinnerMessage = "최종 우승자 : ";

    public static void getCarNameInputMessage() {
        System.out.println(carNameInputMessage);
    }

    public static void getTryCountMessage() {
        System.out.println(tryCountMessage);
    }

    public static void getResultMessage() {
        System.out.println(resultMessage);
    }

    public static void getFinalWinnerMessage() {
        System.out.println(finalWinnerMessage);
    }

    public static void showCarNameAndPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + resultPosition(car));
        }
        System.out.println("\n");
    }
}
