package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winner;

import java.util.List;

public class OutputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String DISTANCE = "-";

    public static void inputCarNamesMessage(){
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    public static void inputCountNumberMessage(){
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
    }

    public static void printCarPositionMessage(List<Car> cars){
        for(Car car : cars) {
            printCarPosition(car);
            System.out.println();
        }
    }

    public static void printResultTestMessage(){
        System.out.println(RESULT_MESSAGE);
    }

    private static void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(DISTANCE);
        }
    }

    public static void printWinnerMessage(Winner winner){
        System.out.print(WINNER_MESSAGE);
        System.out.println(winner.getWinnerNames());
    }
}
