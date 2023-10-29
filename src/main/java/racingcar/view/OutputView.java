package racingcar.view;

import racingcar.constants.GameConstant;
import racingcar.constants.OutputMessage;
import racingcar.model.Car;
import java.util.List;

public class OutputView {

    public static void printPlayResultMessage() {
        System.out.println(OutputMessage.PLAY_RESULT_MESSAGE.getMessage());
    }

    public static void printPlayResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + OutputMessage.COLON.getMessage());
            for(int i=0; i<car.getPosition(); i++) {
                System.out.print(OutputMessage.RESULT_CHARACTER.getMessage());
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinnerMessage() {
        System.out.print(OutputMessage.WINNER_MESSAGE.getMessage());
    }

    public static void printWinner(List<String> winners) {
        StringBuilder gameResult = new StringBuilder();
        for (String name : winners) {
            gameResult.append(OutputMessage.SPACE.getMessage())
                    .append(name).append(GameConstant.SEPARATOR.getStringValue());
        }
        gameResult.deleteCharAt(gameResult.length() - 1);
        System.out.println(gameResult);
    }
}
