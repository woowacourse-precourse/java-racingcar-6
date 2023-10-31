package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {


    private static final String REQUEST_CARNAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRY_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_START_MESSAGE = "\n실행 결과";
    private static final String FINAL_WINNER_START_MESSAGE = "최종 우승자 : ";
    private static final String CAR_PROGRESS = "-";


    public static void printRequestCarNameMessage() {
        System.out.println(REQUEST_CARNAME_MESSAGE);
    }

    public static void printRequestTryNumberMessage() {
        System.out.println(REQUEST_TRY_MESSAGE);
    }

    public static void printResultStartMessage() {
        System.out.println(RESULT_START_MESSAGE);
    }

    public static void printGameResultMessage(List<Car> cars) {

        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printCarLocationMessage(car.getPosition());
        }
        System.out.println();
    }

    public static void printCarLocationMessage(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(CAR_PROGRESS);
        }
        System.out.println();
    }


    public static void printFinalWinner(List<String> winners) {
        System.out.print(FINAL_WINNER_START_MESSAGE);
        String result = String.join(", ", winners);
        System.out.print(result);
    }


}
