package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

import static racingcar.util.ProgramMessage.*;

public class OutputView {
    private static final String BAR = "-";
    private static final String COMMA = ", ";
    private static final String RESULT_FORMAT = "%s : %s";
    private static final int STRING_FIRST_INDEX = 0;
    private static final int NUMBER_FOR_LAST_COMMA_REMOVE = 2;

    public void printCarNameInputGuide() {
        System.out.println(CAR_NAME_INPUT_GUIDE_MESSAGE.getMessage());
    }

    public void printTryNumInputGuide() {
        System.out.println(TRY_NUM_INPUT_GUIDE_MESSAGE.getMessage());
    }

    public void printRacingResult(List<Car> carList) {
        for (Car car : carList) {
            String bar = BAR.repeat(car.getForwardNum());
            System.out.println(String.format(RESULT_FORMAT, car.getName(), bar));
        }
        System.out.print(NEXT_LINE.getMessage());
    }

    public void printResultMessage() {
        System.out.println(EXECUTION_RESULT_NOTIFICATION_MESSAGE.getMessage());
    }

    public void printWinner(List<String> winnerList) {
        String winnerMsg = FINAL_WINNER_NOTIFICATION_MESSAGE.getMessage();

        for (int i = 0; i < winnerList.size(); i++) {
            winnerMsg += winnerList.get(i) + COMMA;
        }

        if (winnerMsg.endsWith(COMMA)) {
            winnerMsg = winnerMsg
                    .substring(STRING_FIRST_INDEX, winnerMsg.length() - NUMBER_FOR_LAST_COMMA_REMOVE);
        }

        System.out.print(winnerMsg);
    }
}
