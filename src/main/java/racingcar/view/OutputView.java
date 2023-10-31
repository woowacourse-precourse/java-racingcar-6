package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    private static final String INPUT_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBERS_OF_MOVES_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void printInputCarsNameMessage() {
        System.out.println(INPUT_CARS_NAME_MESSAGE);
    }

    public static void printInputNumberOfMovesMessage() {
        System.out.println(INPUT_NUMBERS_OF_MOVES_MESSAGE);
    }

    public static void printCurrentLocations(List<Car> movedCar) {
        for (Car car : movedCar) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void printWinnerNames(String winnerNames) {
        System.out.println(WINNER_MESSAGE + winnerNames);
    }
}
