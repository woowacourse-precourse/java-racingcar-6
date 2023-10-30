package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String COLON_SPACE = " : ";
    private static final String CAR_POSITION_LINE = "-";
    private static final String STRING_JOIN_DELIMITER = ",";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";


    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void printPlayResultMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void printCarName(Car car) {
        System.out.print(car.getCarName() + COLON_SPACE);
    }

    public void printCurrentCarPosition(Car car) {
        for (int currentCarPosition = 0; currentCarPosition < car.getAdvanceCount(); currentCarPosition++) {
            System.out.print(CAR_POSITION_LINE);
        }
        System.out.println();
    }
    
    public void printFinalWinner(List<String> winnerList) {
        String winners = String.join(STRING_JOIN_DELIMITER, winnerList);
        System.out.println(FINAL_WINNER_MESSAGE + winners);
    }

}
