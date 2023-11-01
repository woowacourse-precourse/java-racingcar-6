package racingcar.util;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public static final String ASK_NAMES_OF_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ASK_NUMBER_OF_RACE = "시도할 회수는 몇회인가요?";
    public static final String SHOW_RESULT_OF_RACE = "\n실행 결과";
    public static final String SHOW_WINNER = "최종 우승자 : ";

    private OutputView() {
    }

    public static void askNamesOfCars() {
        System.out.println(ASK_NAMES_OF_CARS);
    }

    public static void askNumberOfRace() {
        System.out.println(ASK_NUMBER_OF_RACE);
    }

    public static void showStatusOfCar(List<Car> carList) {
        System.out.println(carList);
    }

    public static void showResultOfRace() {
        System.out.println(SHOW_RESULT_OF_RACE);
    }

    public static void showWinner() {
        System.out.print(SHOW_WINNER);
    }

    public static void showNameOfWinner(StringBuilder stringOfWinners) {
        System.out.println(stringOfWinners);
    }
}
